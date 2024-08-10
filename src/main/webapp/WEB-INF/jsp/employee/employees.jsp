<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 7/29/2024
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />
<!-- a page title -->
<section style="background-color:lightseagreen">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                Employees
            </h1>
        </div>
    </div>
</section>


<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/employee/employees">
                    <div class="mb-3">
                        <label for="email" class="form-label"><h4>Employee Search</h4></label>
                        <input type="text" value="${email}" class="form-control" id="email" name="email"
                               placeholder="Enter employee's email"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
    </div>

    <section>
        <div class="container">
            <%--            <div class="row pt-5">--%>
            <%--                <div class="col-12">--%>
            <%--                    <h2 class="text-center">Employees found (${employees.size()})</h2>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <div class="row pt-3">
                <div class="col-12">
                    <table class="table table-striped">
                        <tr class="text-center" style="background-color:lightseagreen">
                            <th>ID</th>
                            <th>Email</th>
                            <th>Full name</th>
                            <th>Password</th>
                            <th>Edit</th>
                        </tr>
                        <%--                        <c:forEach items="${employees}" var="employee">--%>
                        <tr class="text-center">
                            <td><a href="/employee/employee/${employee.id}">${employee.id}</a></td>
                            <td>${employee.email}</td>
                            <td>${employee.fullName}</td>
                            <td>${employee.password}</td>
                            <td><a href="/employee/edit-employee?employeeId=${employee.id}">edit</a></td>
                        </tr>
                        <%--                        </c:forEach>--%>
                    </table>
                </div>
            </div>
        </div>
    </section>

<jsp:include page="../include/footer.jsp" />