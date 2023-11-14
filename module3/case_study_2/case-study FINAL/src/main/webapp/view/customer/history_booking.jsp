<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/1/2023
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History Booking</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        <jsp:include page="../css/header.css"/>
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
                                ${customer.name}
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
                                        onclick="sendInfoMoDal('${customer.id}','${customer.name}')">
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
                                <h1><input type="hidden" name="id" id="id"></h1>
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
            <div class="col-lg-9 col-12 right  " id="right">
                <div>
                    <c:choose>
                        <c:when test="${bookingList.size()==0}">

                            <div style="text-align: center;margin-top: 250px;font-style: italic;font-size: 25px">
                                <p>Bạn chưa đặt dịch vụ của chúng tôi. </p>
                                <p>Nhanh tay đặt để tận hưởng các dịch vụ hàng đầu chăm sóc thú cưng. </p>
                            </div>
                            <div class="row" style="position: relative ;top: 260px; text-align: center">

                                <div class="col-6">
                                    <a href="/view/home/mainHome.jsp" class="btn btn-warning ">Trang chủ</a>
                                </div>
<%--                                <div class="col-6">--%>
<%--                                    <a href="/booking-management?action=createBookingOnline" class="btn btn-warning ">Booking</a>--%>
<%--                                </div>--%>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div>
                                <h2 class="mb-3 mt-3" style="">Lịch sử booking của bạn</h2>
                            </div>
                            <%--muốn làm search--%>
<%--                            <div class="row ">--%>
<%--                                <div class="col-4">--%>
<%--                                    <button type="button" class="btn btn-warning dropdown-toggle"--%>
<%--                                            data-bs-toggle="dropdown">--%>
<%--                                        Sắp xếp--%>
<%--                                    </button>--%>
<%--                                    <ul class="dropdown-menu">--%>
<%--                                        <li><a class="dropdown-item" href="/customer?action=seach">Tên tăng dần</a></li>--%>
<%--                                        <li><a class="dropdown-item" href="/customer?action=seach">Tên giảm dần</a></li>--%>
<%--                                    </ul>--%>
<%--                                </div>--%>
<%--                                <div class="col-8">--%>
<%--                                    <form action="/customer?action=searchByName" method="post">--%>

<%--                                        <input type="text" class="form-control" name="petName"--%>
<%--                                               placeholder="Nhập tên pet">--%>

<%--                                        <button type="submit" class="btn btn-warning">Tìm kiếm</button>--%>
<%--                                    </form>--%>

<%--                                </div>--%>

<%--                            </div>--%>

                            <table class="table table-hover" id="history">
                                <thead>
                                <tr>
                                    <th>Stt</th>
                                    <th>Mã đặt lịch</th>
                                    <th>Tên pet</th>
                                    <th>Loại pet</th>
                                    <th>Thời gian bắt đầu</th>
                                    <th>Thời gian kết thúc</th>
                                    <th>Trạng thái</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${bookingList}" var="booking" varStatus="loop">
                                    <tr style="font-weight: bold">
                                        <td class="mb-2">${loop.count}</td>
                                        <c:choose>
                                            <c:when test="${booking.bookingId<10}">
                                                <td class="mb-2">B00${booking.bookingId}</td>
                                            </c:when>
                                            <c:when test="${booking.bookingId<100}">
                                                <td class="mb-2">B0${booking.bookingId}</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td class="mb-2">B${booking.bookingId}</td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td class="mb-2">${booking.petName}</td>
                                        <td class="mb-2">${booking.typePetName}</td>
                                        <td class="mb-2">${booking.startTime}</td>
                                        <td class="mb-2">${booking.endTime}</td>
                                        <td class="mb-2">${booking.statusName}</td>
                                        <td class="mb-2">
                                            <a href="/customer?action=detailBooking&bookingId=${booking.bookingId}">Chi
                                                tiết</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                            <div class="row" style="text-align: center">
                                <div class="col-6">
                                    <a href="/view/home/mainHome.jsp" class="btn btn-warning ">Trang chủ</a>
                                </div>
<%--                                <div class="col-6">--%>
<%--                                    <a href="/booking-management?action=createBookingOnline" class="btn btn-warning ">Booking</a>--%>
<%--                                </div>--%>
                            </div>
                            <input type="hidden" name="id" value="${customer.id}">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
<script>
    new DataTable('#history', {
        order: [[0, 'asc']],
        pagingType: 'full_numbers',
        searching: false,
        "dom": 'rtip',
        "bInfo": false,
        "pageLength": 10
    });
</script>
</body>
</html>
