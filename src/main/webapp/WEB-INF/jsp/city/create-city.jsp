<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 7/27/2024
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>


<jsp:include page="../include/header.jsp" />

<!-- a page header -->
<section style="background-color:#C2E8DF">
    <div class="container">
        <div class="row pt-5 pb-5">
            <c:if test="${empty form.cityId}">
                <h1 class="text-center">Create city</h1>
            </c:if>
            <c:if test="${not empty form.cityId}">
                <h1 class="text-center">Edit city</h1>
            </c:if>
        </div>
    </div>
</section>


<section>
    <div class="container">
        <div class="row pt-5 ">
            <div class="col-12">
                <form method="post" action="/city/submit-city" enctype="multipart/form-data">
<%--                <form action="/city/submit-city" method="post" enctype="multipart/form-data">--%>
                    <input type="hidden" name="cityId" value="${form.cityId}">
<%--                    ${form.lastEditorUser <sec:authentication property="name"/>}--%>
<%--                    <input type="hidden" name="editorId" value="<sec:authentication property="name"/>">--%>


                    <!-- city input -->
                    <div class="row align-items-center justify-content-center">
                        <div class="col-2">
                            <label for="cityNameId" class="col-form-label">City name</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="cityNameId" name="name" class="form-control <c:if test="${bindingResult.hasFieldErrors('name')}">is-invalid</c:if>" value="${form.name}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('name')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('name')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- city input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="stateId" class="col-form-label">St/Prov/Dept/Terr</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="stateId" name="stateProvinceDepartmentTerritory" class="form-control
                                <c:if test="${bindingResult.hasFieldErrors('stateProvinceDepartmentTerritory')}">is-invalid</c:if>" value="${form.stateProvinceDepartmentTerritory}"
                            />
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('stateProvinceDepartmentTerritory')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('stateProvinceDepartmentTerritory')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- country input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="countryId" class="col-form-label">Country</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="countryId" name="country" class="form-control <c:if test="${bindingResult.hasFieldErrors('country')}">is-invalid</c:if>" value="${form.country}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('country')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('country')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- slogan input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="sloganId" class="col-form-label">Slogan</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="sloganId" name="slogan" class="form-control <c:if test="${bindingResult.hasFieldErrors('slogan')}">is-invalid</c:if>" value="${form.slogan}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('slogan')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('slogan')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- description input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="descriptionId" class="col-form-label">Description</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="descriptionId" name="description" class="form-control
                                <c:if test="${bindingResult.hasFieldErrors('description')}">is-invalid</c:if>" value="${form.description}"
                            />
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('description')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('description')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- web input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="webId" class="col-form-label">Web URL</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="webId"
                                   name="cityWebUrl"
<%--                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('web')}">is-invalid</c:if>"--%>
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('cityWebUrl')}">is-invalid</c:if>"        //Changed 'web' to 'cityWebUrl' on 08/05/24 11:00AM
                                   value="${form.cityWebUrl}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('cityWebUrl')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('cityWebUrl')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Image file input -->
                    <div class="row align-items-center justify-content-center  pt-3">
                        <div class="col-2">
                            <label for="file" class="col-form-label">City image</label>
                        </div>
                        <div class="col-4">
                            <input type="file" id="file" name="file" class="form-control"
                                   accept=".jpg,.jpeg,.png"
                                               <c:if test="${bindingResult.hasFieldErrors('cityImageUrl')}">is-invalid</c:if>"
                                                value="${form.cityImageUrl}"
                            />
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('cityImageUrl')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <c:forEach items="${bindingResult.getFieldErrors('cityImageUrl')}" var="error">
                                        <div class="text-danger">${error.defaultMessage}</div>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                    </div>



                    <div class="row justify-content-center pt-3 ">
                        <div class="col-auto text-center">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />