<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/6/2023
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        <jsp:include page="../css/header.css"/>
        <jsp:include page="../css/table.css"/>

    </style>
</head>
<body>
<div>
    <jsp:include page="../home/navbar.jsp" />
    <div class="container col-12 main">
        <div class="table-title">
            <div class="row">
                <h2>Chỉnh sửa thông tin</h2>
            </div>
        </div>
        <form action="/admin?action=update" method="post">
            <div class="mb-5 mt-2 row">
                <label for="name" class="col-sm-2 col-form-label">Họ và tên</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="${customer.name}" required>
                </div>
                <div class="col-sm-2"></div>
                <div class="col-sm-10 text-danger">
                    <span><small>${errorName}</small></span>
                </div>
            </div>

            <div class="mb-5 row">
                <label for="birthday" class="col-sm-2 col-form-label">Ngày sinh</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="birthday" name="birthday" value="${customer.birthday}"
                           required>
                </div>
                <div class="col-sm-2"></div>
                <div class="col-sm-10 text-danger">
                    <span><small>${errorDob}</small></span>
                </div>
            </div>

            <div class="mb-5 row">
                <label for="telephone" class="col-sm-2 col-form-label">Số điện thoại</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="telephone" name="telephone"
                           value="${customer.telephone}"
                           required>
                </div>
                <div class="col-sm-2"></div>
                <div class="col-sm-10 text-danger">
                    <span><small>${errorTelephone}</small></span>
                </div>
            </div>
            <div class="mb-5 row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" name="email" value="${customer.email}" required>
                </div>
                <div class="col-sm-2"></div>
                <div class="col-sm-10 text-danger">
                    <span><small>${errorEmail}</small></span>
                </div>
            </div>

            <div class="mb-5 row">
                <label for="address" class="col-sm-2 col-form-label">Địa chỉ</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="address" name="address" value="${customer.address}"
                           required>
                </div>
            </div>
            <div class="mb-5 row">
                <label class="col-sm-2 col-form-label">Giới tính</label>
                <div class="col-sm-10 " id="radio">
                    <c:if test="${customer.gender==1}">
                        <label><input checked="checked" name="gender" value="1" type="radio"/> Nam</label>
                        <label><input name="gender" value="0" type="radio"> Nữ</label>
                    </c:if>
                    <c:if test="${customer.gender==0}">
                        <label><input name="gender" value="1" type="radio"> Nam</label>
                        <label><input checked="checked" name="gender" value="0" type="radio"/> Nữ</label>

                    </c:if>
                </div>
            </div>

            <div class="row" style="text-align: center">
                <div class="col-6">
                    <a href="/view/home/mainHome.jsp" class="btn btn-warning ">Trang chủ</a>
                </div>
                <div class="col-6">
                    <button type="submit" class="btn btn-warning ">Lưu</button>
                </div>
            </div>
            <input type="hidden" name="id" value="${customer.id}">

        </form>
    </div>

</div>
</body>
</html>
