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
<div class="container col-12 main">
    <div class="table-title">
    </div>
    <form method="post">
        <caption>
            <h2>
                Thêm Dịch vụ
            </h2>
        </caption>
        <c:if test="${existingBooking != null}">
            <input type="hidden" name="bookingId" value="<c:out value='${existingBooking.bookingId}' />"/>
        </c:if>
        <div class="mb-4 mt-2 row">
            <label for="serviceId" class="col-sm-2 col-form-label">Chọn dịch vụ(<span
                    style="color: red">*</span>)</label>
            <div class="col-sm-10">
                <select required name="serviceId" id="serviceId">
                    <c:forEach var="service" items="${serviceList}">
                        <option value="${service.serviceId}">${service.serviceName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-4 mt-2 row">
            <label for="sl" class="col-sm-2 col-form-label">Chọn số lượng(<span
                    style="color: red">*</span>)</label>
            <div class="col-sm-10">
                <input id="sl" type="number" name="quantity" required min="0">
            </div>
        </div>
        <div class="row mt-1 mb-2" style="text-align: center">
            <div class="col-6">
                <a href="booking-management" class="btn btn-warning ">Quay lại</a>
            </div>
            <div class="col-6">
                <button type="submit" class="btn btn-warning ">Thêm</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

