<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 8/8/2024
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />
<!-- a page title -->
<section style="background-color:lightseagreen">
  <div class="container">
    <div class="row pt-5 pb-5">
      <h1 class="text-center">
        All events
      </h1>
    </div>
  </div>
</section>

<section>
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
          </tr>
          <c:forEach items="${eventsKey}" var="event">
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