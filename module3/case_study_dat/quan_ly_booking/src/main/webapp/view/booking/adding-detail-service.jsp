<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 07/11/2023
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<center>
    <h1>Thêm Dịch vụ vào Booking</h1>
    <h2>
        <a href="booking-management">Quay về trang quản lý Booking</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Thêm Dịch vụ
                </h2>
            </caption>
            <c:if test="${existingBooking != null}">
                <input type="hidden" name="bookingId" value="<c:out value='${existingBooking.bookingId}' />"/>
            </c:if>
            <tr>
                <th>Chọn dịch vụ:</th>
                <td>
                    <select required name="serviceId" id="serviceId">
                        <c:forEach var="service" items="${serviceList}">
                            <option value="${service.serviceId}">${service.serviceName}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>Chọn số lượng:</th>
                <td>
                    <input type="number" name="quantity" required min="0">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Thêm mới"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

