<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Quan ly chi tiet dich vu</title>
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
    <h2>Danh sách Dịch vụ</h2>

    <table class="table table-success table-striped ">
        <tr>
            <th>Mã chi tiết dịch vụ</th>
            <th>Tên Pet</th>
            <th>Tên Khách hàng</th>
            <th>TG bắt đầu</th>
            <th>TG kết thúc</th>
            <th>Tên dịch vu</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Thành tiền</th>
            <th>Chi tiết</th>
            <th>Chỉnh sửa</th>
        </tr>
        <c:forEach var="detailService" items="${detailServiceList}">
            <tr>
                <td><c:out value="${detailService.detailServiceId}"/></td>
                <td><c:out value="${detailService.petName}"/></td>
                <td><c:out value="${detailService.customerName}"/></td>
                <td><c:out value="${detailService.startTime}"/></td>
                <td><c:out value="${detailService.endTime}"/></td>
                <td><c:out value="${detailService.serviceName}"/></td>
                <td><c:out value="${detailService.quantity}"/></td>
                <td><c:out value="${detailService.price}"/></td>
                <td><c:out value="${detailService.total}"/></td>
                <td>
                    <a href="/booking-management?action=detailService&id=${detailService.detailServiceId}">Chi tiết</a>
                </td>
                <td>
                    <a href="/booking-management?action=updateDetailService&id=${detailService.detailServiceId}">Chỉnh sửa</a>
                </td>
            </tr>
        </c:forEach>
<%--        <tr>--%>
<%--            <td colspan="8" style="text-align: center">Tổng tiền</td>--%>
<%--            <td colspan="3">--%>
<%--                <c:set var = "totalBill" value="${0}"/>--%>
<%--                <c:forEach var="detailService" items="${detailServiceList}">--%>
<%--                    ${totalBill = totalBill + detailService.total}--%>
<%--                </c:forEach>--%>
<%--                ${totalBill}--%>
<%--            </td>--%>
<%--        </tr>--%>
    </table>
</div>
</body>
</html>