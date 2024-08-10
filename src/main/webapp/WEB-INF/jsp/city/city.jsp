<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 7/27/2024
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="../../../pub/css/global.css">


<style>
    .center-container {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    input[type="checkbox"] {
        appearance: none;
        -webkit-appearance: none;
        -moz-appearance: none;
        background-color: #eee;
        border: 1px solid #ddd;
        box-shadow: inset 0 0 0 rgba(0,0,0,.25);
        width: 30px;
        height: 20px;
        outline: none;
    }

    input[type="checkbox"]:checked {
        background-color: #d9edf7;
        border: 1px solid #bce8f1;
        box-shadow: inset 0 0 0 rgba(0,0,0,.25);
    }
</style>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp" />



<section style="background-color:#C2E8DF">
    <h1 class="page-title text-center">${cityKey.name} ${cityKey.stateProvinceDepartmentTerritory} city details</h1>
</section>

<section class="center-container">
    <div class="form-check form-switch">
        <sec:authorize access="isAuthenticated()">
            <form id="formVisitedOrNot">
                <input class="form-check-input" type="checkbox" id="cityVisited" name="visitedCity"

                       <c:if test="${visitedCityKey.cityVisited==1}">checked</c:if>
                />
                <label class="form-check-label" id="labelVisitedOrNot" for="cityVisited">
                    <c:choose>
                        <c:when test="${visitedCityKey.cityVisited==1}">
                            Visited
                        </c:when>
                        <c:otherwise>
                            Not visited
                        </c:otherwise>
                    </c:choose>
                </label>
                <input type="hidden" id="statusField" name="status" class="form-control"/>
            </form>
        </sec:authorize>
    </div>
</section>

<table class="table table-striped">
    <tr><td><b>ID</b></td><td>${cityKey.id}</td></tr>
    <tr><td><b>City name</b></td><td>${cityKey.name}</td></tr>
    <tr><td><b>State/Province/Department/Territory</b></td><td>${cityKey.stateProvinceDepartmentTerritory}</td></tr>
    <tr><td><b>Country</b></td><td>${cityKey.country}</td></tr>
    <tr><td><b>Slogan</b></td><td>${cityKey.slogan}</td></tr>
    <tr><td><b>Description</b></td><td>${cityKey.description}</td></tr>
    <tr><td><b>City's iconic image</b></td><td>${cityKey.cityImageUrl}</td></tr>
    <tr><td><b>City website URL</b></td><td><a href="${cityKey.cityWebUrl}" target="_blank">${cityKey.cityWebUrl}</a></td></tr>
    <tr><td><b>Creation date</b></td><td>${cityKey.createdAt}</td></tr>
    <tr><td><b>Last edition date</b></td><td>${cityKey.editedDate}</td></tr>
    <tr><td><b>City's iconic image</b></td><td><img id="cityImage" src="${cityKey.cityImageUrl}" alt=""/></td></tr>
    <tr><td><b>Last editor</b></td><td>${userKey.email}</td></tr>
    <tr><td></td><td><a href="${pageContext.request.contextPath}/city/edit-city?cityId=${cityKey.id}">edit by @RequestParam</a></td></tr>
</table>

<jsp:include page="../include/footer.jsp" />


<%--<script src="../../../resources/static/script.js"></script>--%>
<%--<script src="../../../static/js/checkbox.js"></script>--%>

<script>

    const checkbox = document.getElementById('cityVisited');
    const label = document.getElementById('labelVisitedOrNot');
    // var statusField = checkbox.checked ? 1 : 0;

    checkbox.addEventListener('change', function() {
        var statusField = this.checked ? 1 : 0;
        console.log("checked " + this.checked);
        if (this.checked) {
            label.textContent = 'Visited';
            console.log("Visited")
        } else {
            label.textContent = 'Not visited';
            console.log("Not visited")
        }
        fetch(`/visitedcity/SaveAsVisitedCity?status=`+statusField+`&cityId=${cityKey.id}`, {})
            .then(data => {console.log('success', data);})
            .catch(error => console.error('Error:', error));

        console.log("checkbox.checked: " + checkbox.checked);
        console.log("statusField: " + statusField);

    });
    // console.log("checkbox.checked: " + checkbox.checked);
    // console.log("statusField: " + statusField);

    <%--fetch(`/visitedcity/SaveAsVisitedCity?status=`+statusField+`&cityId=${cityKey.id}`, {})--%>
    <%--    .then(data => {console.log('success', data)})--%>
    <%--    .catch(error => console.error('Error:', error));--%>

</script>
