<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="booking-management">Quay về trang quản lý Booking</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Chỉnh sửa Booking
                </h2>
            </caption>
            <c:if test="${editingBooking != null}">
                <input type="hidden" name="bookingId" value="<c:out value='${editingBooking.bookingId}' />"/>
                <input type="hidden" name="petId" value="<c:out value='${editingBooking.petId}' />"/>
                <input type="hidden" name="employeeId" value="<c:out value='${editingBooking.employeeId}' />"/>
                <input type="hidden" name="bookingTime" value="<c:out value='${editingBooking.bookingTime}' />"/>
                <input type="hidden" name="estimateTimeOfArrival" value="<c:out value='${editingBooking.estimatedTimeOfArrival}' />"/>
            </c:if>
            <tr>
                <th>Thời gian bắt đầu:</th>
                <td>
                    <input type="datetime-local" name="startTime" size="45"
                           value="<c:out value='${editingBooking.startTime}' />"

                    />
                </td>
            </tr>
            <tr>
                <th>Thời gian kết thúc:</th>
                <td>
                    <input type="datetime-local" name="endTime" size="45"
                           value="<c:out value='${editingBooking.endTime}' />"

                    />
                </td>
            </tr>
            <tr>
                <th>Thạng thái booking:</th>
                <td>
                    <input type="text" name="bookingStatusId" size="15"
                           value="<c:out value='${editingBooking.statusId}' />"
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
