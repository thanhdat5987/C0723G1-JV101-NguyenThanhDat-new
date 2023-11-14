<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/6/2023
  Time: 8:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Quản Lý Khách Hàng</title>
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
<div class="col-12 container main ">
<%--    thêm mới thành công--%>
<%--    <c:if test="${param.get('isCreated')}">--%>
<%--        <p style="color: yellow; background-color: green">Thêm mới thành công</p>--%>
<%--    </c:if>--%>
    <div class="table-title">
        <div class="row">
            <div class="col-sm-6">
                <h2>Quản Lý Khách Hàng</h2>
            </div>
            <div class="col-sm-6">
                <a href="/admin?action=create" class="btn btn-success" >
                    <span>Thêm mới</span></a>
            </div>
        </div>
    </div>
    <table class="table" >
        <thead>
        <tr >
            <th scope="col">Stt</th>
            <th scope="col">Họ và tên</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Email</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer" varStatus="loop">
            <tr>
                <td class="padding">${loop.count}</td>
                <td class="padding">${customer.name}</td>
                <td class="padding"><input style="background-color: #ffff; border: none;font-weight: 500" type="date" disabled
                           value="${customer.birthday}"></td>
                <td class="padding">${customer.email}</td>
                <td style="padding-top: 8px">
                    <a href="/admin?action=update&id=${customer.id}"
                    class="btn btn-outline-light text-warning">
                        <i class="fas fa-pencil-alt"></i></a>
                </td>
                <td>
                    <button type="button" style="border: none"
                            class="list-group-item list-group-item-action btn btn-outline-light text-danger"
                            data-bs-toggle="modal" data-bs-target="#exampleModal"
                            onclick="sendInfoMoDal('${customer.id}','${customer.name}')">
                        <i class="fas fa-trash-alt"></i>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--        modal--%>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/admin?action=remove" method="post">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5 text-warning" id="exampleModalLabel">Xác nhận xoá</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <h1><input type="hidden" name="id" id="id"></h1>
                        Bạn có chắc chắc muốn xoá <span id="name" class="text text-warning"></span> không?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                        <button type="submit" class="btn btn-warning">Xoá</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--toast--%>
<div id="toast" class="toast text-light position-fixed top-0 w-25" role="alert" aria-live="assertive" aria-atomic="true">
    <div class="toast-body">
        <p id="toast-content"></p>
    </div>
</div>

<script>
    function sendInfoMoDal(id, name) {
        document.getElementById("id").value = id;
        document.getElementById("name").innerText = name;
    }
    function displayToast(mess,backgroud){
        document.getElementById("toast-content").innerText= mess;
        document.getElementById("toast").style.background= backgroud;
        let toastEl = document.getElementById("toast");
        let toast = new bootstrap.Toast(toastEl);
        toast.show();
    }
    <c:if test="${param.get('isCreated')}">
    displayToast("Thêm mới thành công","#FFA500");
    </c:if>
    <c:if test="${param.get('isUpdate')}">
    displayToast("Chỉnh sửa thành công","#FFA500");
    </c:if>
    <c:if test="${param.get('isDelete')}">
    displayToast("Xóa thành công","#FFA500");
    </c:if>
</script>
</body>
</html>



