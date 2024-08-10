<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 8/1/2024
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/header.jsp" />
<%--<h1>500 Error page</h1>--%>
<div class="container">
    <div class="row pt-5 pb-5">
        <img src="../../../pub/images/errors/500Error.png" class="main500content">
    </div>
</div>

<sec:authorize access="hasAnyAuthority('ADMIN')">
    <div style="margin-left:30px;" class="pb-5">
        <br><br>
        <c:if test="${not empty requestUrl}">
            <p>${requestUrl}</p>
        </c:if>
        <h3>Stack Trace</h3>
        <c:if test="${not empty message}">
            <p>${message}</p>
        </c:if>
        <c:if test="${not empty stackTrace}">
            <p>${stackTrace}</p>
        </c:if>
        <c:if test="${not empty rootCause}">
            <h3>Root Cause</h3>
            <p>${rootCause}</p>
        </c:if>
        <c:if test="${not empty rootTrace}">
            <p>${rootTrace}</p>
        </c:if>
    </div>
</sec:authorize>

<jsp:include page="../include/footer.jsp" />