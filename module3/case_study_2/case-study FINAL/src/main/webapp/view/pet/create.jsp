<%--
  Created by IntelliJ IDEA.
  User: TGDD
  Date: 11/5/2023
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
            <h2>Thêm mới thú cưng</h2>
        </div>
    </div>
    <form method="post">
        <div class="mb-4 mt-2 row">
            <label for="name" class="col-sm-2 col-form-label">Tên thú cưng(<span style="color: red">*</span>)</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
        </div>
        <div class="mb-4 mt-2 row">
            <label for="weight" class="col-sm-2 col-form-label">Cân nặng(<span
                    style="color: red">*</span>)</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="weight" name="weight" required>
            </div>
        </div>
        <div class="mb-4 mt-2 row">
            <label for="descriptions" class="col-sm-2 col-form-label">Mô tả(<span style="color: red">*</span>)</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="descriptions" name="descriptions" required>
            </div>
        </div>
        <div class="mb-4 mt-2 row">
            <label for="id_type_pet" class="col-sm-2 col-form-label">Mã thú cưng(<span
                    style="color: red">*</span>)</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="id_type_pet" name="id_type_pet" required>
            </div>
        </div>

        <div class="row mt-1 mb-2" style="text-align: center">
            <div class="col-6">
                <a href="/service" class="btn btn-warning ">Quay lại</a>
            </div>
            <div class="col-6">
                <button type="submit" class="btn btn-warning ">Thêm</button>
            </div>
        </div>
        <input type="hidden" name="role" value="3">
        <input type="hidden" name="id" value="${service.getId()}">

    </form>
</div>
</body>
</html>
