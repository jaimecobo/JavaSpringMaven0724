<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 7/26/2024
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section style="background-color:lightseagreen">
    <h1 class="page-title text-center">Employee details</h1>
</section>

<table class="table table-striped">
    <tr><td><b>ID</b></td><td>${employeeKey.id}</td></tr>
    <tr><td><b>Email</b></td><td>${employeeKey.email}</td></tr>
    <tr><td><b>Full name</b></td><td>${employeeKey.fullName}</td></tr>
    <tr><td><b>Password</b></td><td>${employeeKey.password}</td></tr>
<%--    <tr><td></td><td><a href="/edit-employee?employeeId=${employeeKey.id}">edit by @RequestParam</a></td></tr>--%>
    <tr><td></td><td><a href="${pageContext.request.contextPath}/employee/edit-employee?employeeId=${employeeKey.id}">edit by @RequestParam</a></td></tr>
</table>

<jsp:include page="../include/footer.jsp" />