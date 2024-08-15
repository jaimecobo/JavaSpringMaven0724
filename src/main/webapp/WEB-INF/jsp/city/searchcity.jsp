<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 7/27/2024
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />
<!-- a page title -->
<section style="background-color:#C2E8DF">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">
                Cities
            </h1>
        </div>
    </div>
</section>


<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8 text-center">
                <form action="/city/search-city">
                    <div class="mb-3">
                        <label for="name" class="form-label"><h4>Search for city</h4></label>
                        <input type="text" value="${city}" class="form-control" id="name" name="name"
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
                    <h2 class="text-center">Cities found (${cities.size()})</h2>
                </div>
            </div>
            <div class="row pt-3">
                <div class="col-12">
                    <table class="table table-striped">
                        <tr class="text-center" style="background-color:#C2E8DF">
                            <th>ID</th>
                            <th>City site</th>
                            <th>Edit</th>
                        </tr>
                        <c:forEach items="${cities}" var="city">
                            <tr class="text-center">
                                <td><a href="/city/edit-city?cityId=${city.id}">${city.id}</a></td>
                                <td><a href="/city/city/${city.id}">${city.name}</a></td>
                                <td><a href="/city/edit-city?cityId=${city.id}">edit</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </section>

<jsp:include page="../include/footer.jsp" />