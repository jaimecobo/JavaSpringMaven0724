<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 7/25/2024
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="../../../pub/css/radiobutton.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section style="background-color:lightblue">
    <h1 class="page-title text-center">User details</h1>
</section>

<section>
    <div class="normal-container">
        <div class="smile-rating-container">
            <div class="smile-rating-toggle-container">
                <form class="submit-rating" id="formFollowOrNot">
                    <input class="form-check-input" type="radio" id="unfollow" name="follow"
                           <c:if test="${relationshipKey.followerOrNot==0}">checked</c:if>
                    />
                    <input class="form-check-input" type="radio" id="follow" name="follow"
                           <c:if test="${relationshipKey.followerOrNot==1}">checked</c:if>
                    />
                    <label for="unfollow" class="rating-label rating-label-unfollow">Unfollow</label>
                    <div class="smile-rating-toggle"></div>
                    <div class="rating-eye rating-eye-left"></div>
                    <div class="rating-eye rating-eye-right"></div>
                    <div class="mouth rating-eye-bad-mouth"></div>
                    <div class="toggle-rating-pill"></div>
                    <label for="follow" class="rating-label rating-label-follow">Follow</label>
                </form>
            </div>
        </div>
    </div>
</section>

<table class="table table-striped">
    <tr><td><b>ID</b></td><td>${userKey.id}</td></tr>
    <tr><td><b>Username</b></td><td>${userKey.username}</td></tr>
    <tr><td><b>Email</b></td><td>${userKey.email}</td></tr>
    <tr><td><b>Brand/Nickname/Company</b></td><td>${userKey.brandNicknameCompany}</td></tr>
    <tr><td><b>First name</b></td><td>${userKey.firstName}</td></tr>
    <tr><td><b>Last name</b></td><td>${userKey.lastName}</td></tr>
    <tr><td><b>Gender</b></td><td>${userKey.gender}</td></tr>
    <tr><td><b>Phone number</b></td><td>${userKey.phone}</td></tr>
    <tr><td><b>Address</b></td><td>${userKey.address}</td></tr>
    <tr><td><b>City</b></td><td>${userKey.city}</td></tr>
    <tr><td><b>State/Province/Department/Territory</b></td><td>${userKey.state}</td></tr>
    <tr><td><b>Zip Code</b></td><td>${userKey.zipCode}</td></tr>
    <tr><td><b>Country</b></td><td>${userKey.country}</td></tr>
    <tr><td><b>Password</b></td><td>${userKey.password}</td></tr>
    <tr><td><b>Creation date</b></td><td>${userKey.createdAt}</td></tr>
    <tr><td><b>Profile image</b></td><td><img id="userImage" src="${userKey.userImageUrl}" alt=""/></td></tr>
    <tr><td></td><td><a href="${pageContext.request.contextPath}/user/edit-user?userId=${userKey.id}">edit by @RequestParam</a></td></tr>
</table>

<section style="background-color:lightblue">
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Visited cities found (${listOfVisitedCitiesKey.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-striped">
                    <tr class="text-center" style="background-color:lightcyan">
                        <th>Id</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Country</th>
                        <th>Edit</th>
                    </tr>
                    <c:forEach items="${listOfVisitedCitiesKey}" var="visitedCity">
                        <tr class="text-center">
                            <td><a href="/city/edit-city?cityId=${visitedCity.id}">${visitedCity.id}</a></td>
                            <td><a href="/city/city/${visitedCity.id}">${visitedCity.city}</a></td>
                            <td>${visitedCity.state}</td>
                            <td>${visitedCity.country}</td>
                            <td><a href="/city/edit-city?cityId=${visitedCity.id}">edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>


<section style="background-color:lightblue">
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Followers found (${ListOfFollowersKey.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-striped">
                    <tr class="text-center" style="background-color:lightcyan">
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Country</th>
<%--                        <th>Edit</th>--%>
                    </tr>
                    <c:forEach items="${ListOfFollowersKey}" var="follower">
                        <tr class="text-center">
                            <td>${follower.firstName}</td>
                            <td>${follower.lastName}</td>
                            <td><a href="/user/user/${follower.id}">${follower.username}</a></td>
                            <td>${follower.email}</td>
                            <td>${follower.city}</td>
                            <td>${follower.state}</td>
                            <td>${follower.country}</td>
<%--                            <td><a href="/user/edit-user?userId=${follower.id}">edit</a></td>--%>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>


<section style="background-color:lightblue">
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">You follow (${ListOfWhoYouFollowKey.size()}) users</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-striped">
                    <tr class="text-center" style="background-color:lightcyan">
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Country</th>
                        <%--                        <th>Edit</th>--%>
                    </tr>
                    <c:forEach items="${ListOfWhoYouFollowKey}" var="following">
                        <tr class="text-center">
                            <td>${following.firstName}</td>
                            <td>${following.lastName}</td>
                            <td><a href="/user/user/${following.id}">${following.username}</a></td>
                            <td>${following.email}</td>
                            <td>${following.city}</td>
                            <td>${following.state}</td>
                            <td>${following.country}</td>
<%--                            <td><a href="/user/edit-user?userId=${following.id}">edit</a></td>--%>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>


<section style="background-color:lightblue">
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Organized events (${organizedEventsKey.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-striped">
                    <tr class="text-center" style="background-color:lightcyan">
                        <th>Event name</th>
                        <th>Description</th>
                        <th>City</th>
                        <th>Starting date</th>
                    </tr>
                    <c:forEach items="${organizedEventsKey}" var="event">
                        <tr class="text-center">
                            <td><a href="/event/event/${event.id}">${event.name}</a></td>
                            <td>${event.description}</td>
                            <td><a href="/city/city/${event.city.id}">${event.city.name}</a></td>
                            <td>${event.startingDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>

<%--<script src="../../../static/js/radiobuttons.js"></script>--%>

<script>

    document.getElementById('unfollow').addEventListener('click', function(){
            if (this.checked) {
                fetch(`/relationship/followedOrNot?status=`+0+`&userId=${userKey.id}`)
                    .then(data => console.log('success unfollowing'))
                    .catch(error => console.error('Error:', error));
            }
        });

    document.getElementById('follow').addEventListener('click', function(){
        if (this.checked) {
            fetch(`/relationship/followedOrNot?status=`+1+`&userId=${userKey.id}`)
            .then(data => console.log('success following'))
            .catch(error => console.error('Error:', error));
        }
    });

</script>