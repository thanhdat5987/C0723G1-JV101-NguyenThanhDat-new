<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chinh sua detail service</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    <style>
        <jsp:include page="../css/header.css"/>
        <jsp:include page="../css/table.css"/>
    </style>
</head>
<body>
<div>
    <jsp:include page="../home/navbar.jsp"/>
</div>
<center>
    <h1>Chỉnh sửa Chi tiết dịch vụ</h1>
    <h2>
        <a href="booking-management">Quay về trang quản lý Booking</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Chỉnh sửa Chi tiết dịch vụ
                </h2>
            </caption>
            <c:if test="${existingDetailService != null}">
                <input type="hidden" name="detailServiceId"
                       value="<c:out value='${existingDetailService.detailServiceId}' />"/>
            </c:if>
            <tr>
                <th>Tên dịch vụ</th>
                <th>Thay đổi số lượng</th>
            </tr>
            <tr>
                <td>
                    <c:out value='${existingDetailService.serviceName}'/>
                </td>
                <td>
                    <input required type="number" name="quantity" size="45"
                           value="<c:out value='${existingDetailService.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Lưu thay đổi"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
