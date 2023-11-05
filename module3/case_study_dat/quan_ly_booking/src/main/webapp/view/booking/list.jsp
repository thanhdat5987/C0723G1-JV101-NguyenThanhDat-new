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
    <title>Booking list</title>
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
    </style>
</head>
<body>
<div class="container">
    <h1>Booking Management</h1>
    <form action="/booking-management">
        <input hidden="hidden" type="text" name="action" value="findByCountry">
        <input type="text" name="name">
        <button class="btn btn-primary">Find booking date</button>
    </form>
    <button class="btn btn-primary"><a href="/booking-management?action=create">Add New Booking</a></button>
    <h2>List of Users</h2>
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
                    <a href="/booking-management?action=edit&id=${booking.bookingId}">Edit</a>
                    <a href="/booking-management?action=delete&id=${booking.bookingId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
