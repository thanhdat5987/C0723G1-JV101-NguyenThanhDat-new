<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/3/2023
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm mới tài khoản</title>
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
                <h2>Nhập Thông Tin Tài Khoản</h2>
            </div>
        </div>
                <form method="post">
                    <div class="mb-4 mt-2 row">
                        <label for="username" class="col-sm-2 col-form-label">Tài khoản(<span style="color: red">*</span>)</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                    </div>
                    <div class="mb-4 mt-2 row">
                        <label for="password" class="col-sm-2 col-form-label">Mật khẩu(<span style="color: red">*</span>)</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                    </div>
                    <div class="mb-4 mt-2 row">
                        <label for="roles" class="col-sm-2 col-form-label">Roles</label>
                        <div class="col-sm-10">
                            <select name="roles" id="roles">
                                <c:forEach items="${roleList}" var="role">
                                    <option value="${role.getIdRole()}">${role.getRoles()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row mt-2" style="text-align: center">
                        <div class="col-6">
                            <a href="/accounts" class="btn btn-warning">Quay lại</a>
                        </div>
                        <div class="col-6">
                            <input hidden="hidden" name="role" value="3"/>
                            <input type="submit" value="Lưu"/>
                        </div>
                    </div>
                </form>
        </div>
    </div>
</body>
</html>