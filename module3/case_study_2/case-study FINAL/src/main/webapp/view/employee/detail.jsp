<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 11/6/23
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        <jsp:include page="../css/header.css"/>
    </style>
</head>
<body>
<div>
    <jsp:include page="../home/navbar.jsp" />

    <div class="container">
        <div class="row mt-5">
            <div class="col-lg-3 col-12 left ">
                <div class="accordion accordion-flush" id="accordionFlushExample">
                    <div class="accordion-item">
                        <img src="${employee.getImage()}" style="width: 100%" alt="image">

                    </div>
                </div>
            </div>

            <div class="col-lg-9 col-12 right row  " id="right">
                <div>
                    <h2 class="mb-3 mt-3" style="">Thông tin nhân viên ${employee.getName()}</h2>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext " disabled value="Mã nhân viên"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <c:choose>
                            <c:when test="${employee.getId()<10}">
                                <input class="form-control-plaintext" disabled value="NV00${employee.getId()}"/>
                            </c:when>
                            <c:when test="${employee.getId()<100}">
                                <input class="form-control-plaintext" disabled value="NV0${employee.getId()}"/>
                            </c:when>
                            <c:otherwise>
                                <input class="form-control-plaintext" disabled value="NV-${employee.getId()}"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext " disabled value="Họ và tên:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="${employee.getName()}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext " disabled value="Ngày sinh:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input type="date" class="form-control-plaintext" disabled value="${employee.getBirthday()}"/>
                    </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="Số điện thoại:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="${employee.getPhoneNumber()}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="Email:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="${employee.getEmail()}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="Địa chỉ:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="${employee.getAddress()}"/>
                    </div>
                </div><div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="Số CCCD"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="${employee.getIdentificationCard()}"/>
                    </div>
                </div><div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="Lương"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="${employee.getSalary()}"/>
                    </div>
                </div>
<%--                    <c:if test="${sessionScope.account.roleId==2}">--%>
<%--                        <div class="border row">--%>
<%--                            <div class="col-lg-3 col-md-5 col-12 mb-3">--%>
<%--                                <input style="opacity: 1" class="form-control-plaintext" disabled value="Lương"/>--%>
<%--                            </div>--%>
<%--                            <div class="col-lg-9 col-md-7 col-12 mb-3">--%>
<%--                                <input style="opacity: 1" class="form-control-plaintext"--%>
<%--                                       value="${employee.getUsername()}"/>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </c:if>--%>
                <div class="row mt-2" style="text-align: center">
                    <c:if test="${sessionScope.account.roleId==2}">
                    <div class="col-6">
                        <a href="/employee?" class="btn btn-warning" >Quay lại</a>
                    </div>
                    </c:if>
                    <div class="col-6">
                        <a href="/employee?action=edit&username=${username}" type="submit" class="btn btn-warning "
                        >Chỉnh sửa</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
