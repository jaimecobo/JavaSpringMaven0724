<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 8/7/2024
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />
<!-- a page title -->
<section style="background-color:#C2E8DF">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                All cities
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Cities found (${cities.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-striped">
                    <tr class="text-center" style="background-color:#C2E8DF">
                        <th>ID</th>
                        <th>City name</th>
                        <th>State</th>
                        <th>Country</th>
                        <th>Edit</th>
                    </tr>
                    <c:forEach items="${cities}" var="city">
                        <tr class="text-center">
                            <td><a href="/city/edit-city?cityId=${city.id}">${city.id}</a></td>
                            <td><a href="/city/city/${city.id}">${city.name}</a></td>
                            <td>${city.stateProvinceDepartmentTerritory}</td>
                            <td>${city.country}</td>
                            <td><a href="/city/edit-city?cityId=${city.id}">edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />