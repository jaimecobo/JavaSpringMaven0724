<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 8/5/2024
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../include/header.jsp" />

<section style="background-color:lightseagreen">
    <h1 class="page-title text-center">Event details</h1>
</section>

<table class="table table-striped">
    <tr><td><b>ID</b></td><td>${eventKey.id}</td></tr>
    <tr><td><b>Event name</b></td><td>${eventKey.name}</td></tr>
    <tr><td><b>Description</b></td><td>${eventKey.description}</td></tr>
    <tr><td><b>City</b></td><td>${eventKey.city.name}</td></tr>
    <tr><td><b>Organizer</b></td><td>${eventKey.organizer.username}</td></tr>
    <tr><td><b>Starting date</b></td><td>${eventKey.startingDate}</td></tr>
    <tr><td><b>Ending date</b></td><td>${eventKey.endingDate}</td></tr>
    <tr><td><b>Creation date</b></td><td>${eventKey.createdAt}</td></tr>
    <tr><td><b>Event website URL</b></td><td>${eventKey.eventWebUrl}</td></tr>
    <tr><td><b>Event image</b></td><td><img id="eventImage" src="${eventKey.eventImageUrl}"/></td></tr>
    <tr><td></td><td><a href="${pageContext.request.contextPath}/event/edit-event?eventId=${eventKey.id}">edit by @RequestParam</a></td></tr>
</table>

<jsp:include page="../include/footer.jsp" />