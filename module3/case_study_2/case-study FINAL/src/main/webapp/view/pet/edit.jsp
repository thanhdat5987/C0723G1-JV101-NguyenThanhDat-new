<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/6/2023
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        <jsp:include page="../css/header.css"/>
        <jsp:include page="../css/edit.css"/>
        <jsp:include page="../css/table.css"/>
    </style>
</head>
<body>
<div>
    <jsp:include page="../home/navbar.jsp" />
    <div class="container col-12 main">
        <div class="table-title">
            <div class="row">
                <h2>Chỉnh sửa thông tin thú cưng</h2>
            </div>
        </div>
        <form action="/pet?action=update" method="post">
            <div class="mb-5 mt-2 row">
                <label for="name" class="col-sm-2 col-form-label">Tên</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="${pet.getName()}" required>
                </div>
            </div>

            <div class="mb-5 row">
                <label for="weight" class="col-sm-2 col-form-label">Cân nặng</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="weight" name="weight" value="${pet.getWeight()}"
                           required>
                </div>
            </div>

            <div class="mb-5 row">
                <label for="des" class="col-sm-2 col-form-label">Mô tả</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="des" name="description"
                           value="${pet.getDescriptions()}"
                           required>
                </div>
            </div>
            <div class="mb-5 row">
                <label for="idType" class="col-sm-2 col-form-label">Loại pet</label>
                <div class="col-sm-10">
                    <select name="id_type_pet" id="idType">
                        <option value="1">Chó</option>
                        <option value="2">Mèo</option>
                    </select>
                </div>
            </div>
            <div class="mb-5 row">
                <label for="idCus" class="col-sm-2 col-form-label">Mã khách hàng</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control"  id="idCus" name="idCustomer"
                           value="${pet.id_customer}"
                           >
                </div>
            </div>

            <div class="row" style="text-align: center">
                <div class="col-6">
                    <a href="/view/home/mainHome.jsp" class="btn btn-warning ">Trang chủ</a>
                </div>
                <div class="col-6">
                    <button type="submit" class="btn btn-warning ">Lưu</button>
                </div>
            </div>
            <input type="hidden" name="id" value="${pet.getId()}">

        </form>
    </div>

</div>
</body>
</html>
