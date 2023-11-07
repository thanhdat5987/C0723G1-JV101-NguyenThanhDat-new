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
    <button class="btn btn-success"><a href="/booking-management?action=create">Thêm mới Booking</a></button>
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
        <c:forEach var="booking" items="${bookingList}">
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
                    <a href="/booking-management?action=edit&id=${booking.bookingId}">Sửa</a>
                    <a href="/booking-management?action=delete&id=${booking.bookingId}">Xoá</a>
                </td>
                <td>
                    <a href="#">Thêm</a>
                    <a href="#">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
