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
    <title>Thêm mới booking</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        <jsp:include page="../css/header.css"/>
        <jsp:include page="../css/table.css"/>
    </style>
</head>
<body>
<jsp:include page="../home/navbar.jsp"/>
<div class="container col-12 main">
    <div class="table-title">
        <div class="row">
            <h2>Nhập Thông Tin Booking</h2>
        </div>
    </div>
    <form method="post">
        <div class="mb-4 mt-2 row">
            <label for="petId" class="col-sm-2 col-form-label">Thêm pet(<span style="color: red">*</span>)</label>
            <div class="col-sm-10">
                <select required name="petId" id="petId">
                    <c:forEach var="status" items="${petList}">
                        <option value="${status.petId}">${status.petName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-4 mt-2 row">
            <label for="employeeId" class="col-sm-2 col-form-label">Thêm nhân viên(<span
                    style="color: red">*</span>)</label>
            <div class="col-sm-10">
                <select required name="employeeId" id="employeeId">
                    <c:forEach var="status" items="${employeeList}">
                        <option value="${status.employeeId}">${status.employeeName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-1 mb-2" style="text-align: center">
            <div class="col-6">
                <a href="/booking-management" class="btn btn-warning ">Quay lại</a>
            </div>
            <div class="col-6">
                <button type="submit" class="btn btn-warning ">Thêm</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
