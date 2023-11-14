<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/26/2023
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        <jsp:include page="../css/header.css"/>
        <jsp:include page="../css/customer-style.css"/>
        .toast{
            text-align: center;
        }
    </style>

</head>
<body>
<jsp:include page="../home/navbar.jsp" />
<div class="main">
    <div class="container">
        <div class="row mt-5">
            <div class="col-lg-3 col-12 left ">
                <div class="accordion accordion-flush" id="accordionFlushExample">
                    <div class="accordion-item">
                        <img src="https://lh3.googleusercontent.com/pw/ADCreHdcZUhrWshJRjRHbr4UYoGIJZNZq-WBWPG_Ob_xLR6uF2dl6RECcEt3oWABvzNmELXhaFXk-yBMr9Q2hm4qfhGSCrVDJTrsG6ZH9s-ChWDBD9ZOeJXEEwIQ7NaUQhuTvrq9DByUvscdAO0z1Y1qCH4=w1458-h1458-s-no-gm?authuser=0" style="width: 100%">
                        <h2 class="accordion-header" id="flush-headingOne">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-collapseOne" aria-expanded="false"
                                    aria-controls="flush-collapseOne" style="font-weight: bold">
                                ${customer.name}
                            </button>
                        </h2>
                        <div id="flush-collapseOne" class="accordion-collapse collapse "
                             aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body ">
                                <a href="/customer?id=${account.getAccountId()}"
                                   class="list-group-item list-group-item-action mb-3 btn btn-warning" >Thông
                                    tin cá nhân</a>
                                <a href="/customer?action=update&id=${account.getAccountId()}"
                                   class="list-group-item list-group-item-action mb-3  btn btn-warning">Chỉnh
                                    sửa thông tin</a>

                                <a href="/customer?action=history&id=${account.getAccountId()}" class="list-group-item list-group-item-action mb-3  btn btn-warning">
                                    Lịch sử booking</a>
                                <button type="button"
                                        class="list-group-item list-group-item-action mb-3 btn btn-outline-warning text-danger"
                                        data-bs-toggle="modal" data-bs-target="#exampleModal"
                                        onclick="sendInfoMoDal('${account.getAccountId()}','${customer.name}')">
                                    Xóa tài khoản
                                </button>
                                <a href="/home?action=logout"
                                   class="list-group-item list-group-item-action btn btn-outline-warning text-danger">Đăng
                                    xuất</a>
                            </div>
                        </div>
                    </div>
                </div>
<%--                <c:if test="${flag}">--%>
<%--                    <div class="toast show">--%>
<%--                        <div class="toast-header">--%>
<%--                            Toast Header--%>
<%--                            <button type="button" class="btn-close" data-bs-dismiss="toast"></button>--%>
<%--                        </div>--%>
<%--                        <div class="toast-body">--%>
<%--                            Some text inside the toast body--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:if>--%>
            </div>
            <%--            modal--%>
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/customer?action=remove" method="post">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5 text-warning" id="exampleModalLabel">Xác nhận xoá</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h1><input type="hidden" name="accountId" id="accountId"></h1>
                                Bạn có chắc chắc muốn xoá <span id="name" class="text text-warning"></span> không?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                                <button type="submit" class="btn btn-warning">Xoá</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 col-12 right row  " id="right">
                <div>
                    <h2 class="mb-3 mt-3" style="">Thông tin quý khách ${customer.name}</h2>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext " disabled value="Mã khách hàng:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <c:choose>
                            <c:when test="${customer.id<10}">
                                <input class="form-control-plaintext" disabled value="B00${customer.id}"/>
                            </c:when>
                            <c:when test="${customer.id<100}">
                                <input class="form-control-plaintext" disabled value="B0${customer.id}"/>
                            </c:when>
                            <c:otherwise>
                                <input class="form-control-plaintext" disabled value="B${customer.id}"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext " disabled value="Họ và tên:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="${customer.name}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext " disabled value="Ngày sinh:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input type="date" class="form-control-plaintext" disabled value="${customer.birthday}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="Số điện thoại:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="${customer.telephone}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="Email:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input class="form-control-plaintext" disabled value="${customer.email}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="Địa chỉ:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="${customer.address}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 mb-3">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="Giới tính:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 mb-3">
                        <c:if test="${customer.gender==0}">
                            <input style="opacity: 1" class="form-control-plaintext" disabled value="Nữ"/>
                        </c:if>
                        <c:if test="${customer.gender==1}">
                            <input style="opacity: 1" class="form-control-plaintext" disabled value="Nam"/>
                        </c:if>
                    </div>
                </div>
                <div class="row mt-2" style="text-align: center">
                    <div class="col-6">
                        <a href="/view/home/mainHome.jsp" class="btn btn-warning" >Trang chủ</a>
                    </div>
                    <div class="col-6">
                        <a href="/customer?action=update&id=${account.getAccountId()}" type="submit" class="btn btn-warning "
                           >Chỉnh sửa</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--toast--%>
<div id="toast" class="toast text-light position-fixed top-0 w-25" role="alert" aria-live="assertive" aria-atomic="true">
    <div class="toast-body">
        <p id="toast-content"></p>
    </div>
</div>
<script>
    function sendInfoMoDal(id,name) {
        document.getElementById("accountId").value=id;
        document.getElementById("name").innerText=name;
    }
    function displayToast(mess,background){
        document.getElementById("toast-content").innerText= mess;
        document.getElementById("toast").style.background= background;
        let toastEl = document.getElementById("toast");
        let toast = new bootstrap.Toast(toastEl);
        toast.show();
    }

    <c:if test="${param.get('isUpdate')}">
    displayToast("Chỉnh sửa thành công","#FFA500");
    </c:if>
</script>
</body>
</html>
