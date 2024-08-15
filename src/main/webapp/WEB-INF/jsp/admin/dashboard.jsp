<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 7/30/2024
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section style="background-color:darkcyan">
    <h1 class="page-title text-center">Admin Dashboard</h1>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Users found (${usersKey.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-striped">
                    <tr class="text-center" style="background-color:lightblue">
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${usersKey}" var="user">
                        <tr class="text-center">
                            <td><a href="/user/edit-user?userId=${user.id}">${user.id}</a></td>
                            <td><a href="/user/user/${user.id}">${user.username}</a></td>
                            <td><a>${user.email}</a></td>
                            <td><a>${user.firstName}</a></td>
                            <td><a>${user.lastName}</a></td>
                            <td><a href="/user/edit-user?userId=${user.id}">edit</a></td>
                            <td><a class="btn btn-outline-danger" href="/user/delete-user?userId=${user.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Events found (${eventsKey.size()})</h2>
            </div>
        </div>
    </div>
    <div class="container">
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
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${eventsKey}" var="event">
                        <tr class="text-center">
                            <td><a href="/event/edit-event?eventId=${event.id}">${event.id}</a></td>
                            <td><a href="/event/event/${event.id}">${event.name}</a></td>
                            <td><a href="/city/city/${event.cityId}">${event.city.name}</a></td>
                            <td>${event.startingDate}</td>
                            <td>${event.endingDate}</td>
                            <td><a href="/event/edit-event?eventId=${event.id}">edit</a></td>
                            <td><a class="btn btn-outline-danger" href="/event/delete-event?eventId=${event.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>


<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Cities found (${citiesKey.size()})</h2>
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
                        <th>Delete</th>

                    </tr>
                    <c:forEach items="${citiesKey}" var="city">
                        <tr class="text-center">
                            <td><a href="/city/edit-city?cityId=${city.id}">${city.id}</a></td>
                            <td><a href="/city/city/${city.id}">${city.name}</a></td>
                            <td>${city.stateProvinceDepartmentTerritory}</td>
                            <td>${city.country}</td>
                            <td><a href="/city/edit-city?cityId=${city.id}">edit</a></td>
                            <td><a class="btn btn-outline-danger" href="/city/delete-city?cityId=${city.id}">Delete</a></td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />