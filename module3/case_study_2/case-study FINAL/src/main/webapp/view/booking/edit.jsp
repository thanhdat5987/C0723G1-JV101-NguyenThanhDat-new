<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Pet Management Application</title>
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
