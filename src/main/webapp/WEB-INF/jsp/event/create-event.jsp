<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 8/5/2024
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<!-- a page header -->
<section style="background-color:lightseagreen">
    <div class="container">
        <div class="row pt-5 pb-5">
            <c:if test="${empty form.eventId}">
                <h1 class="text-center">Create Event</h1>
            </c:if>
            <c:if test="${not empty form.eventId}">
                <h1 class="text-center">Edit Event</h1>
            </c:if>
        </div>
    </div>
</section>



<section>
    <div class="container">
        <div class="row pt-5 ">
            <div class="col-12">
                <form action="/event/submit-event" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="eventId" value="${form.eventId}">

                    <!-- name input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="eventNameId" class="col-form-label">Event name</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="eventNameId" name="name" class="form-control <c:if test="${bindingResult.hasFieldErrors('name')}">is-invalid</c:if>" value="${form.name}">
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


                    <!-- Description input -->
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



                    <!-- City input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="cityId" class="col-form-label">City</label>
                        </div>
                        <div class="col-4">
                            <select id="cityId" name="cityId" class="form-control">
                                <c:forEach items="${citiesKey}" var="city">
                                    <option
                                            value="${city.id}"
                                            <c:if test="${city.id == form.cityId}"> selected</c:if>
                                    >
                                            ${city.name} ${city.stateProvinceDepartmentTerritory}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                    <!-- Starting date input field -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="startingDateId" class="col-form-label">Starting date</label>
                        </div>
                        <div class="col-4">
                            <input type="date"
                                   id="startingDateId"
                                   name="startingDate"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('startingDate')}">is-invalid</c:if>"
                                   value="${form.startingDate}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('startingDate')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('startingDate')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Ending date input field -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="endingDateId" class="col-form-label">Ending date</label>
                        </div>
                        <div class="col-4">
                            <input type="date"
                                   id="endingDateId"
                                   name="endingDate"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('endingDate')}">is-invalid</c:if>"
                                   value="${form.endingDate}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('endingDate')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('endingDate')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- web input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="eventWebId" class="col-form-label">Event web URL</label>
                        </div>
                        <div class="col-4">
                            <input type="text"
                                   id="eventWebId"
                                   name="eventWebUrl"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('eventWebUrl')}">is-invalid</c:if>"
                                   value="${form.eventWebUrl}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('eventWebUrl')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('eventWebUrl')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- Image file input -->
                    <div class="row align-items-center justify-content-center  pt-3">
                        <div class="col-2">
                            <label for="file" class="col-form-label">Event image</label>
                        </div>
                        <div class="col-4">
                            <input type="file" id="file" name="file" class="form-control"
                                   accept=".jpg,.jpeg,.png"
                                   <c:if test="${bindingResult.hasFieldErrors('eventImageUrl')}">is-invalid</c:if>"
                            value="${form.eventImageUrl}"
                            />
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('eventImageUrl')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <c:forEach items="${bindingResult.getFieldErrors('eventImageUrl')}" var="error">
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


<jsp:include page="../include/footer.jsp"/>
