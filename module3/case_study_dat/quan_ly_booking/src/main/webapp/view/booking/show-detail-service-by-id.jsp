<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Chi tiet dich vu</title>
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
<div class="container">
    <h1>Chi tiết dịch vụ</h1>
    <button class="btn btn-success"><a href="/booking-management">Quay lại</a></button>
    <table class="table table-success table-striped " style="width: 60%; margin-top: 10px ">
        <tr>
            <th>Nội dung</th>
            <th>Thông tin</th>
        </tr>
        <tr>
            <td>Tên Khách hàng</td>
            <td>${detailService.customerName}</td>
        </tr>
        <tr>
            <td>Tên Pet</td>
            <td>${detailService.petName}</td>
        </tr>
        <tr>
            <td>Tên Nhân Viên</td>
            <td>${detailService.employeeName}</td>
        </tr>
        <tr>
            <td>Thời gian bắt đầu</td>
            <td>${detailService.startTime}</td>
        </tr>
        <tr>
            <td>Thời gian kết thúc</td>
            <td>${detailService.endTime}</td>
        </tr>
        <tr>
            <td>Tên Dịch vụ</td>
            <td>${detailService.serviceName}</td>
        </tr>
        <tr>
            <td>Đơn giá</td>
            <td>${detailService.price}</td>
        </tr>
        <tr>
            <td>Số lượng</td>
            <td>${detailService.quantity}</td>
        </tr>
        <tr>
            <td>Thành tiền (1000 đồng)</td>
            <td>${detailService.total}</td>
        </tr>
    </table>
</div>
</body>
</html>