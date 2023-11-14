<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/5/2023
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detail History</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>

        <jsp:include page="../css/customer-style.css"/>

    </style>
</head>
<body>
<jsp:include page="../home/navbar.jsp"/>
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
                                ${bookingDetail.name}
                            </button>
                        </h2>
                        <div id="flush-collapseOne" class="accordion-collapse collapse "
                             aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body ">
                                <a href="/customer?id=${account.getAccountId()}"
                                   class="list-group-item list-group-item-action mb-3 btn btn-warning">Thông
                                    tin cá nhân</a>
                                <a href="/customer?action=update&id=${account.getAccountId()}"
                                   class="list-group-item list-group-item-action mb-3  btn btn-warning">Chỉnh
                                    sửa thông tin</a>

                                <a href="/customer?action=history&id=${account.getAccountId()}"
                                   class="list-group-item list-group-item-action mb-3  btn btn-warning">
                                    Lịch sử booking</a>
                                <button type="button"
                                        class="list-group-item list-group-item-action mb-3 btn btn-outline-warning text-danger"
                                        data-bs-toggle="modal" data-bs-target="#exampleModal"
                                        onclick="sendInfoMoDal('${bookingDetail.id}','${bookingDetail.name}')">
                                    Xóa tài khoản
                                </button>
                                <a href="/home?action=logout"
                                   class="list-group-item list-group-item-action btn btn-outline-warning text-danger">Đăng
                                    xuất</a>
                            </div>
                        </div>
                    </div>
                </div>
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
            <div class="col-lg-9 col-12 right row " id="right">
                <div>
                    <h2 class="mb-3 mt-3" style="">Chi tiết lịch sử booking ${bookingDetail.name}</h2>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 ">
                        <input class="form-control-plaintext " disabled value="Mã booking:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 ">
                        <c:choose>
                            <c:when test="${bookingDetail.bookingId<10}">
                                <input class="form-control-plaintext" disabled value="B00${bookingDetail.bookingId}"/>
                            </c:when>
                            <c:when test="${bookingDetail.bookingId<100}">
                                <input class="form-control-plaintext" disabled value="B0${bookingDetail.bookingId}"/>
                            </c:when>
                            <c:otherwise>
                                <input class="form-control-plaintext" disabled value="B${bookingDetail.bookingId}"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 ">
                        <input class="form-control-plaintext " disabled value="Tên pet:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 ">
                        <input class="form-control-plaintext" disabled value="${bookingDetail.petName}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 ">
                        <input class="form-control-plaintext " disabled value="Loại pet:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 ">
                        <input  class="form-control-plaintext" disabled
                               value="${bookingDetail.typePetName}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 ">
                        <input class="form-control-plaintext" disabled value="Nhân viên:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 ">
                        <input class="form-control-plaintext" disabled value="${bookingDetail.employeeName}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 ">
                        <input class="form-control-plaintext" disabled value="Thời gian bắt đầu:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 ">
                        <input class="form-control-plaintext" disabled value="${bookingDetail.startTime}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 ">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="Thời gian kết thúc:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 ">
                        <input style="opacity: 1" class="form-control-plaintext" disabled
                               value="${bookingDetail.endTime}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 ">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="Trạng thái booking :"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 ">
                        <input style="opacity: 1" class="form-control-plaintext" disabled
                               value="${bookingDetail.statusName}"/>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 ">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="Dịch vụ:"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 ">
                        <c:forEach items="${serviceDetail}" var="s">
                            <input style="opacity: 1" class="form-control-plaintext" disabled
                                   value="${s.serviceName} [${s.quantity} ${s.unit}] ${s.priceTotal} đồng "/>
                        </c:forEach>
                    </div>
                </div>
                <div class="border row">
                    <div class="col-lg-3 col-md-5 col-12 ">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="Tổng tiền :"/>
                    </div>
                    <div class="col-lg-9 col-md-7 col-12 ">
                        <input style="opacity: 1" class="form-control-plaintext" disabled value="${sumPrice} đồng"/>
                    </div>
                </div>

                <div class="row mt-2" style="text-align: center">
                    <div class="col-6">
                        <a href="/view/home/mainHome.jsp" class="btn btn-warning">Trang chủ</a>
                    </div>
                    <div class="col-6">
                        <a href="/customer?action=history&id=${account.getAccountId()}" class="btn btn-warning">Trở về</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function sendInfoMoDal(id,name) {
        document.getElementById("accountId").value=id;
        document.getElementById("name").innerText=name;
    }
</script>
</body>
</html>
