<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 8/8/2024
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />
<!-- a page title -->
<section style="background-color:lightseagreen">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                Events
            </h1>
        </div>
    </div>
</section>


<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/event/events-by-city">
                    <div class="mb-3">
                        <label for="cityId" class="col-form-label"><h4>Search events by city</h4></label>
                    </div>
                    <div class="col-12 pb-3">
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
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>
</section>


<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Events found in ${cityKey.name} ${cityKey.stateProvinceDepartmentTerritory} (${eventsInCityKey.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-striped">
                    <tr class="text-center" style="background-color:lightseagreen">
                        <th>ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Starting date</th>
                        <th>Ending date</th>
                        <th>Edit</th>
                    </tr>
                    <c:forEach items="${eventsInCityKey}" var="event">
                        <tr class="text-center">
                            <td><a href="/event/edit-event?eventId=${event.id}">${event.id}</a></td>
                            <td><a href="/event/event/${event.id}">${event.name}</a></td>
                            <td><a href="/city/city/${event.cityId}">${event.city.name}</a></td>
                            <td>${event.startingDate}</td>
                            <td>${event.endingDate}</td>
                            <td><a href="/event/edit-event?eventId=${event.id}">edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />