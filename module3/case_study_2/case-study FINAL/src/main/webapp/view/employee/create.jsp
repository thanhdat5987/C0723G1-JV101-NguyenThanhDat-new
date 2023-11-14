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
    <title>Thêm mới nhân viên</title>
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
                <h2>Nhập Thông Tin Nhân viên</h2>
            </div>
        </div>
        <form method="post">
            <div class="mb-4 mt-2 row">
                <label for="name" class="col-sm-2 col-form-label">Họ và tên(<span style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="birthday" class="col-sm-2 col-form-label">Ngày sinh</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="birthday" name="birthday" required>
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="phone" class="col-sm-2 col-form-label">Số điện thoại(<span style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" name="phoneNumber" required>
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="email" class="col-sm-2 col-form-label">Email(<span style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="address" class="col-sm-2 col-form-label">Địa chỉ(<span style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="address" name="address" required>
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="cccd" class="col-sm-2 col-form-label">Số CCCD(<span style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="cccd" name="identificationCard" required>
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="salary" class="col-sm-2 col-form-label">Lương</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="salary" name="salary">
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="image" class="col-sm-2 col-form-label">Link ảnh</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="image" name="image" >
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="username" class="col-sm-2 col-form-label">Tài khoản(<span style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
            </div>
            <div class="mb-4 mt-2 row">
                <label for="pass" class="col-sm-2 col-form-label">Mật khẩu(<span style="color: red">*</span>)</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="pass" name="password" value="123">
                </div>
            </div>

            <div class="row mt-1 mb-2" style="text-align: center">
                <div class="col-6">
                    <a href="/employee" class="btn btn-warning ">Quay lại</a>
                </div>
                <div class="col-6">
                    <button type="submit" class="btn btn-warning ">Thêm</button>
                </div>
            </div>
            <input type="hidden" name="role" value="3">
            <input type="hidden" name="id" value="${employee.getId()}">

        </form>
    </div>


</div>
</body>
</html>
