<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index JSP</title>
</head>
<body>
<h1>Danh Sach Khach Hang
</h1>
<table>
    <tr>
        <th>Họ và tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
<tr>
    <td>${customer.name}</td>
    <td>${customer.dateOfBirth}</td>
    <td>${customer.address}</td>
    <td>${customer.avatar}</td>
</tr>
    </c:forEach>
</table>
</body>
</html>