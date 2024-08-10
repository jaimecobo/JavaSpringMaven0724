<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 8/8/2024
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 7/25/2024
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<!-- a page title -->
<section style="background-color:lightblue">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                Users by city
            </h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/user/users-by-city">
                    <div class="mb-3">
                        <label for="city" class="form-label"><h4>Search users by city</h4></label>
                        <input type="text" value="${cityNameKey}" class="form-control" id="city" name="city"
                               placeholder="Enter city name"/>
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
                <h2 class="text-center">Users found in ${cityNameKey} (${usersKey.size()})</h2>
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
                    </tr>
                    <c:forEach items="${usersKey}" var="user">
                        <tr class="text-center">
                            <td><a href="/user/edit-user?userId=${user.id}">${user.id}</a></td>
                            <td><a href="/user/user/${user.id}">${user.username}</a></td>
                            <td><a>${user.email}</a></td>
                            <td><a>${user.firstName}</a></td>
                            <td><a>${user.lastName}</a></td>
                            <td><a href="/user/edit-user?userId=${user.id}">edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>

