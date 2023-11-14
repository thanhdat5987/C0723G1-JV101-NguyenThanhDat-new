<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Pet Management Application</title>--%>
<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>--%>
<%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>--%>
<%--<style>--%>
<%--    <jsp:include page="../css/header.css"/>--%>
<%--    a {--%>
<%--        text-decoration: none;--%>
<%--        color: white;--%>
<%--    }--%>
<%--    h2{--%>
<%--        padding-top: 20px;--%>
<%--        padding-bottom: 20px;--%>
<%--    }--%>
<%--</style>--%>

<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
<%--    <jsp:include page="../home/navbar.jsp"/>--%>
<%--</div>--%>
<%--<div class="col-12 container main ">--%>
<%--    <div class="table-title">--%>
<%--        <div class="row">--%>
<%--            <div class="col-sm-6">--%>
<%--                <h2>Quản Lý Booking</h2>--%>
<%--            </div>--%>
<%--            <div class="col-sm-6">--%>
<%--                <a href="/booking-management?action=create" class="btn btn-success" >--%>
<%--                    <span>Thêm mới booking</span></a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <table class="table" >--%>
<%--        <thead>--%>
<%--        <tr >--%>
<%--            <th>Mã booking</th>--%>
<%--            <th>Tên Pet</th>--%>
<%--            <th>Tên Khách hàng</th>--%>
<%--            <th>Tên Nhân viên</th>--%>
<%--            <th>TG booking</th>--%>
<%--            <th>TG dự kiến tới</th>--%>
<%--            <th>TG bắt đầu</th>--%>
<%--            <th>TG kết thúc</th>--%>
<%--            <th>Trạng thái booking</th>--%>
<%--            <th>Chỉnh sửa</th>--%>
<%--            <th>Dịch vụ</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach var="booking" items="${bookingList}">--%>
<%--            <tr>--%>
<%--                <td class="padding">${booking.bookingId}</td>--%>
<%--                <td class="padding">${booking.petName}</td>--%>
<%--                <td class="padding">${booking.customerName}</td>--%>
<%--                <td class="padding">${booking.employeeName}</td>--%>
<%--                <td class="padding">${booking.bookingTime}/></td>--%>
<%--                <td class="padding">${booking.estimatedTimeOfArrival}/></td>--%>
<%--                <td class="padding">${booking.startTime}/></td>--%>
<%--                <td class="padding">${booking.endTime}/></td>--%>
<%--                <td class="padding">${booking.bookingStatus}/></td>--%>

<%--                <td style="padding-top: 8px">--%>
<%--                    <a href="/booking-management?action=edit&id=${booking.bookingId}"--%>
<%--                       class="btn btn-outline-light text-warning">--%>
<%--                        <i class="fas fa-pencil-alt"></i></a>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <button type="button" style="border: none"--%>
<%--                            class="list-group-item list-group-item-action btn btn-outline-light text-danger"--%>
<%--                            data-bs-toggle="modal" data-bs-target="#exampleModal"--%>
<%--                            onclick="sendInfoMoDal('${booking.bookingId}')">--%>
<%--                        <i class="fas fa-trash-alt"></i>--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <a href="/booking-management?action=addingDetailService&id=${booking.bookingId}">Thêm</a>--%>
<%--                    <a href="/booking-management?action=listDetailService&id=${booking.bookingId}">Chi tiết</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--    &lt;%&ndash;        modal&ndash;%&gt;--%>
<%--    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"--%>
<%--         aria-hidden="true">--%>
<%--        <div class="modal-dialog">--%>
<%--            <div class="modal-content">--%>
<%--                <form action="/booking-management?action=delete" method="post">--%>
<%--                    <div class="modal-header">--%>
<%--                        <h1 class="modal-title fs-5 text-warning" id="exampleModalLabel">Xác nhận xoá</h1>--%>
<%--                        <button type="button" class="btn-close" data-bs-dismiss="modal"--%>
<%--                                aria-label="Close"></button>--%>
<%--                    </div>--%>
<%--                    <div class="modal-body">--%>
<%--                        <h1><input type="hidden" name="id" id="id"></h1>--%>
<%--                        Bạn có chắc chắc muốn xoá không?--%>
<%--                    </div>--%>
<%--                    <div class="modal-footer">--%>
<%--                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>--%>
<%--                        <button type="submit" class="btn btn-warning">Xoá</button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div >--%>
<%--        <a href="/view/home/mainHome.jsp"  class="btn btn-warning" >Trang chủ</a>--%>
<%--    </div>--%>
<%--</div>--%>

<%--</body>--%>

<%--</html>--%>

<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 03/11/2023
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quan ly booking</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        a {
            text-decoration: none;
            color: white;
        }
        h2{
            padding-top: 20px;
            padding-bottom: 20px;
        }
    </style>
</head>
<body>
<div style="padding: 5px">
    <h1>Quản Lý Booking</h1>
    <a class="btn btn btn-success " href="/booking-management?action=create">Thêm mới Booking</a>
    <h2>Danh sách Booking</h2>
    <table class="table table-success table-striped ">
        <tr>
            <th>Mã booking</th>
            <th>Tên Pet</th>
            <th>Tên Khách hàng</th>
            <th>Tên Nhân viên</th>
            <th>TG booking</th>
            <th>TG dự kiến tới</th>
            <th>TG bắt đầu</th>
            <th>TG kết thúc</th>
            <th>Trạng thái booking</th>
            <th>Chỉnh sửa</th>
            <th>Dịch vụ</th>
        </tr>
        <c:forEach varStatus="status" var="booking" items="${bookingList}">
            <tr>
                <td><c:out value="${booking.bookingId}"/></td>
                <td><c:out value="${booking.petName}"/></td>
                <td><c:out value="${booking.customerName}"/></td>
                <td><c:out value="${booking.employeeName}"/></td>
                <td><c:out value="${booking.bookingTime}"/></td>
                <td><c:out value="${booking.estimatedTimeOfArrival}"/></td>
                <td><c:out value="${booking.startTime}"/></td>
                <td><c:out value="${booking.endTime}"/></td>
                <td><c:out value="${booking.bookingStatus}"/></td>
                <td>
                    <a class="btn btn-success" href="/booking-management?action=edit&id=${booking.bookingId}">Sửa</a>
                    <a class="btn btn-success" href="/booking-management?action=delete&id=${booking.bookingId}">Xoá</a>
                </td>
                <td>
                    <a href="/booking-management?action=addingDetailService&id=${booking.bookingId}">Thêm</a>
                    <a href="/booking-management?action=listDetailService&id=${booking.bookingId}">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
