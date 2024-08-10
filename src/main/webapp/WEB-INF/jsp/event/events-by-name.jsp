<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 8/5/2024
  Time: 9:52 AM
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
                <form action="/event/events-by-name">
                    <div class="mb-3">
                        <label for="name" class="form-label"><h4>Search events by name</h4></label>
                        <input type="text" value="${eventKey}" class="form-control" id="name" name="name"
                               placeholder="Enter event name"/>
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
                <h2 class="text-center">Cities found (${eventsKey.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-striped">
                    <tr class="text-center" style="background-color:lightseagreen">
                        <th>ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Occurring date</th>
                        <th>Edit</th>
                    </tr>
                    <c:forEach items="${eventsKey}" var="event">
                        <tr class="text-center">
                            <td><a href="/event/edit-event?eventId=${event.id}">${event.id}</a></td>
                            <td><a href="/event/event/${event.id}">${event.name}</a></td>
                            <td><a href="/city/city/${event.city.id}">${event.city.name}</a></td>
                            <td>${event.startingDate}</td>
                            <td><a href="/event/edit-event?eventId=${event.id}">edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />