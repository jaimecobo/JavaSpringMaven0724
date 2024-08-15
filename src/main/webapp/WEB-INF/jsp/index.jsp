
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="include/header.jsp" />

<section style="background-color:#248E90">
    <div class="container">
            <sec:authorize access="hasAnyAuthority('ADMIN')">
                <h2 class="text-center"><a style="color: #555e63" href="/admin/dashboard">Admin</a></h2>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <h2 class="text-center"><a style="color: #555e63" href="/account/loginPageUrl">Login page</a></h2>
            </sec:authorize>
            <h2 class="text-center"><a style="color: #555e63" href="/user/create-user">Create user</a></h2>
            <h2 class="text-center"><a style="color: #555e63" href="/city/create-city">Create city</a></h2>
            <h2 class="text-center"><a style="color: #555e63" href="/event/create-event">Create event</a></h2>

            <sec:authorize access="isAuthenticated()">
                <h2 class="text-center"><a style="color: #555e63" href="/account/logout">Logout</a></h2>
                <span class="nav-link text-center"><sec:authentication property="name"/></span>
            </sec:authorize>
                <%--            <h2 class="text-center"><a href="/employee/create-employee">Create employee</a></h2>--%>


        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp" />