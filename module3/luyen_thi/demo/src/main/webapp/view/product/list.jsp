<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>HELLOOOOO</h1>
<table>
    <tr>
        <th>#</th>
        <th>Mã hàng hoá</th>
        <th>Tên hàng hoá</th>
        <th>Đơn vị tính</th>
        <th>Giá</th>
        <th>Loại hàng hoá</th>
        <th>Ngày thu hoạch</th>
        <th>Chỉnh Sửa</th>
        <th>Xoá</th>
    </tr>
    <c:forEach varStatus="status" items="${productList}" var="product">
        <tr>
            <td>${status.count}</td>
            <td>${product.productCode}</td>
            <td>${product.productName}</td>
            <td>${product.unit}</td>
            <td>${product.price}</td>
            <td>${product.productTypeName}</td>
            <td>${product.harvestDate}</td>
            <td>Chinh sua</td>
            <td>Ngay thu hoach</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
