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
    <h1>Thêm mới booking</h1>
    <h2>
        <a href="booking-management?action=booking">Quay về Trang quản lý Booking</a>
    </h2>
    <form method="post">
        <table>
            <tr>
                <td>Nhập Id pet</td>
                <td>
                    <input type="text" name="petId" id="petId" size="45"/>
                </td>
            </tr>
            <tr>
                <td>Nhập Id nhân viên</td>
                <td>
                    <select>
                        <option></option>
                    </select>
                    <input type="text" name="employeeId" id="employeeId" size="45"/>
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
