<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DS Khach Hang</title>
    <style>
        table {
            border-collapse: collapse;
        }
        td, th {
            border: 1px solid;
            text-align: left;
            padding: 8px;
        }
    </style>
</head>
<body>
<h1>Danh Sách Khách Hàng</h1>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.dateOfBirth}</td>
            <td>${customer.address}</td>
            <td><img src="${customer.avatar}" style="height: 100px;width: 80px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
