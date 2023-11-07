<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 04/11/2023
  Time: 22:01
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
    <h1>Thêm mới booking</h1>
    <h2>
        <a href="booking-management">Quay về trang quản lý Booking</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Thêm mới Booking
                </h2>
            </caption>
            <tr>
                <th>Thêm Pet:</th>
                <td>
                    <select required name="petId" id="petId">
                        <c:forEach var="status" items="${petList}">
                            <option value="${status.petId}">${status.petName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Thêm nhân viên:</th>
                <td>
                    <select required name="employeeId" id="employeeId">
                        <c:forEach var="status" items="${employeeList}">
                            <option value="${status.employeeId}">${status.employeeName}</option>
                        </c:forEach>
                    </select>
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
