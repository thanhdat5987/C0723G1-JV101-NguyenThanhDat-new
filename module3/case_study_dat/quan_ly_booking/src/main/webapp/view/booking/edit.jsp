<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Pet Management Application</title>
</head>
<body>
<center>
    <h1>Chỉnh sửa Booking</h1>
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
                <input type="hidden" name="bookingTime" value="<c:out value='${editingBooking.bookingTime}' />"/>
                <input type="hidden" name="estimateTimeOfArrival"
                       value="<c:out value='${editingBooking.estimatedTimeOfArrival}' />"/>
            </c:if>
            <tr>
                <th>Chọn nhân viên:</th>
                <td>
                    <select required name="employeeId" id="employeeId">
                        <c:forEach var="employee" items="${employeeList}">
                            <option value="${employee.employeeId}">${employee.employeeName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Thời gian bắt đầu:</th>
                <td>
                    <input required type="datetime-local" name="startTime" size="45"
                           value="<c:out value='${editingBooking.startTime}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Thời gian kết thúc:</th>
                <td>
                    <input required type="datetime-local" name="endTime" size="45"
                           value="<c:out value='${editingBooking.endTime}' />"
                    />
                </td>
            </tr>
            </tr>
            <tr>
                <th>Thạng thái booking:</th>
                <td>
                    <select required name="bookingStatusId" id="status-select">
                    <c:forEach var="status" items="${bookingStatusList}">
                        <option value="${status.bookingStatusId}">${status.bookingStatusName}</option>
                    </c:forEach>
                    </select>

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
