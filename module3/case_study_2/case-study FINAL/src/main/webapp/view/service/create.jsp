<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 11/2/23
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới dịch vụ</title>
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

<div>
    <jsp:include page="../home/navbar.jsp"/>
    <div class="container col-12 main">
        <div class="table-title">
            <div class="row">
                <h2>Nhập Thông Tin Dịch Vụ</h2>
            </div>
        </div>
        <form method="post">
            <div class="mb-4 mt-2 row">
                <label for="name" class="col-sm-2 col-form-label">Tên dịch vụ(<span style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="price" class="col-sm-2 col-form-label">Giá dịch vụ(<span
                        style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="price" name="price" required>
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="unit" class="col-sm-2 col-form-label">Đơn vị(<span style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="unit" name="unit" required>
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
</div>
</body>
</html>
