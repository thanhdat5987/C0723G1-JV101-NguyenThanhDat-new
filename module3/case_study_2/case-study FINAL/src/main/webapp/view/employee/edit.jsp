<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 11/2/23
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin nhân viên</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        <jsp:include page="../css/header.css"/>
    </style>
</head>
<body>
<div>
    <jsp:include page="../home/navbar.jsp"/>

    <div class="container">
        <div class="row mt-5">
            <div class="col-lg-3 col-12 left ">
                <div class="accordion accordion-flush" id="accordionFlushExample">
                    <div class="accordion-item">
                        <img src="${employee.getImage()}" style="width: 100%" alt="image">

                    </div>
                </div>
            </div>

            <div class="col-lg-9 col-12 right row " id="right">
                <div>
                    <h2 class="mb-3 mt-3" style="">Thông tin nhân viên ${employee.getName()}</h2>
                </div>
                <form method="post">
                    <div class="border row">
                        <div class="col-lg-3 col-md-5 col-12 mb-3">
                            <label for="name" class="form-control-plaintext ">Họ và tên:</label>
                        </div>
                        <div class="col-lg-9 col-md-7 col-12 mb-3">
                            <input name="name" id="name" class="form-control-plaintext" value="${employee.getName()}"/>
                        </div>
                    </div>
                    <div class="border row">
                        <div class="col-lg-3 col-md-5 col-12 mb-3">
                            <label class="form-control-plaintext " for="birthday">Ngày sinh:</label>
                        </div>
                        <div class="col-lg-9 col-md-7 col-12 mb-3">
                            <input name="birthday" id="birthday" type="date" class="form-control-plaintext"
                                   value="${employee.getBirthday()}"/>
                        </div>
                        <div class="border row">
                            <div class="col-lg-3 col-md-5 col-12 mb-3">
                                <label class="form-control-plaintext" for="birthday">Số điện thoại:</label>
                            </div>
                            <div class="col-lg-9 col-md-7 col-12 mb-3">
                                <input name="phoneNumber" id="phoneNumber" class="form-control-plaintext"
                                       value="${employee.getPhoneNumber()}"/>
                            </div>
                        </div>
                        <div class="border row">
                            <div class="col-lg-3 col-md-5 col-12 mb-3">
                                <label class="form-control-plaintext" for="email">Email:</label>
                            </div>
                            <div class="col-lg-9 col-md-7 col-12 mb-3">
                                <input name="email" id="email" class="form-control-plaintext" value="${employee.getEmail()}"/>
                            </div>
                        </div>
                        <div class="border row">
                            <div class="col-lg-3 col-md-5 col-12 mb-3">
                                <label style="opacity: 1" for="address" class="form-control-plaintext">Địa chỉ:</label>
                            </div>
                            <div class="col-lg-9 col-md-7 col-12 mb-3">
                                <input name="address" id="address" style="opacity: 1" class="form-control-plaintext"
                                       value="${employee.getAddress()}"/>
                            </div>
                        </div>
                        <div class="border row">
                            <div class="col-lg-3 col-md-5 col-12 mb-3">
                                <label style="opacity: 1" class="form-control-plaintext" for="cccd">Số CCCD:</label>
                            </div>
                            <div class="col-lg-9 col-md-7 col-12 mb-3">
                                <input name="identificationCard" id="cccd" style="opacity: 1" class="form-control-plaintext"
                                       value="${employee.getIdentificationCard()}"/>
                            </div>

                        </div>
                        <c:if test="${sessionScope.account.roleId==2}">
                            <div class="border row">
                                <div class="col-lg-3 col-md-5 col-12 mb-3">
                                    <label style="opacity: 1" class="form-control-plaintext" for="salary1">Lương</label>
                                </div>
                                <div class="col-lg-9 col-md-7 col-12 mb-3">
                                    <input name="salary" id="salary1" style="opacity: 1" class="form-control-plaintext"
                                           value="${employee.getSalary()}"/>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.account.roleId==3}">
                            <input hidden="hidden" type="text" name="salary" id="salary" size="15"
                                   value="${employee.getSalary()}"/>
                        </c:if>
                        <div class="row mt-2" style="text-align: center">
                            <div class="col-6">
                                <a href="/employee" class="btn btn-warning">Quay lại</a>
                            </div>
                            <div class="col-6">
                                <input hidden="hidden" name="role" value="${sessionScope.account.roleId}"/>
                                <input type="submit" value="Lưu"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
