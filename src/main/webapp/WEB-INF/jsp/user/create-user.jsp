<%--
  Created by IntelliJ IDEA.
  User: jaime
  Date: 7/25/2024
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<!-- a page header -->
<section style="background-color:lightblue">
    <div class="container">
        <div class="row pt-5 pb-5">
            <c:if test="${empty form.userId}">
                <h1 class="text-center">Create User</h1>
            </c:if>
            <c:if test="${not empty form.userId}">
                <h1 class="text-center">Edit User</h1>
            </c:if>
        </div>
    </div>
</section>



<section>
    <div class="container">
        <div class="row pt-5 ">
            <div class="col-12">
                <form action="/user/submit-user" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="userId" value="${form.userId}">


    <!-- username input -->
                    <div class="row align-items-center justify-content-center">
                        <div class="col-2">
                            <label for="usernameId" class="col-form-label">Username</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="usernameId" name="username" class="form-control <c:if test="${bindingResult.hasFieldErrors('username')}">is-invalid</c:if>" value="${form.username}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('username')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('username')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <!-- email input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="emailId" class="col-form-label">Email</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="emailId" name="email" class="form-control <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>" value="${form.email}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('email')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>



                    <!-- password input field -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="passwordId" class="col-form-label">Password</label>
                        </div>
                        <div class="col-4">
                            <input type="password"
                                   id="passwordId"
                                   name="password"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('password')}">is-invalid</c:if>"
                                   value="${form.password}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('password')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div style="color:red">
                                    <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- brandNicknameCompany input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="brandNicknameCompanyId" class="col-form-label">Brand/Nickname/Company</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="brandNicknameCompanyId"
                                   name="brandNicknameCompany" class="form-control
                                    <c:if test="${bindingResult.hasFieldErrors('brandNicknameCompany')}">is-invalid</c:if>" value="${form.brandNicknameCompany}"
                            />
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('brandNicknameCompany')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('brandNicknameCompany')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- firstName input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="firstNameId" class="col-form-label">First name</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="firstNameId" name="firstName" class="form-control <c:if test="${bindingResult.hasFieldErrors('firstName')}">is-invalid</c:if>" value="${form.firstName}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- lastName input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="lastNameId" class="col-form-label">Last name</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="lastNameId" name="lastName" class="form-control <c:if test="${bindingResult.hasFieldErrors('lastName')}">is-invalid</c:if>" value="${form.lastName}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- gender input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="genderId" class="col-form-label">Gender</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="genderId" name="gender" class="form-control <c:if test="${bindingResult.hasFieldErrors('gender')}">is-invalid</c:if>" value="${form.gender}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('gender')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('gender')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- phone input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="phoneId" class="col-form-label">Phone number</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="phoneId" name="phone" class="form-control <c:if test="${bindingResult.hasFieldErrors('phone')}">is-invalid</c:if>" value="${form.phone}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('phone')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('phone')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- address input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="addressId" class="col-form-label">Address</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="addressId" name="address" class="form-control <c:if test="${bindingResult.hasFieldErrors('address')}">is-invalid</c:if>" value="${form.address}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('address')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('address')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- city input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="cityId" class="col-form-label">City</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="cityId" name="city" class="form-control <c:if test="${bindingResult.hasFieldErrors('city')}">is-invalid</c:if>" value="${form.city}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('city')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('city')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- state input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="stateId" class="col-form-label">State</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="stateId" name="state" class="form-control <c:if test="${bindingResult.hasFieldErrors('state')}">is-invalid</c:if>" value="${form.state}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('state')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('state')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- country input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="countryId" class="col-form-label">Country</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="countryId" name="country" class="form-control <c:if test="${bindingResult.hasFieldErrors('country')}">is-invalid</c:if>" value="${form.country}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('country')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('country')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- country input -->
                    <div class="row align-items-center justify-content-center pt-3">
                        <div class="col-2">
                            <label for="zipCodeId" class="col-form-label">Zip code</label>
                        </div>
                        <div class="col-4">
                            <input type="text" id="zipCodeId" name="zipCode" class="form-control <c:if test="${bindingResult.hasFieldErrors('zipCode')}">is-invalid</c:if>" value="${form.zipCode}">
                        </div>
                    </div>
                    <c:if test="${bindingResult.hasFieldErrors('zipCode')}">
                        <div class="row align-items-center justify-content-center">
                            <div class="offset-2 col-4">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('zipCode')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>


                    <!-- user image input -->
                    <div class="row align-items-center justify-content-center  pt-3">
                        <div class="col-2">
                            <label for="file" class="col-form-label">User image</label>
                        </div>
                        <div class="col-4">
                            <input type="file" id="file" name="file" class="form-control"
                                   accept=".jpg,.jpeg,.png"
                                   <c:if test="${bindingResult.hasFieldErrors('userImageUrl')}">is-invalid</c:if>"
                                   value="${form.userImageUrl}"
                            />
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('userImageUrl')}">
                            <div class="row align-items-center justify-content-center">
                                <div class="offset-2 col-4">
                                    <c:forEach items="${bindingResult.getFieldErrors('userImageUrl')}" var="error">
                                        <div class="text-danger">${error.defaultMessage}</div>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                    </div>


                    <div class="row justify-content-center pt-3 ">
                        <div class="col-auto text-center">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>