<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
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
    <div class="table-title">
        <div class="row">
            <div class="col-sm-6">
                <h2>Quản Lý Nhân viên</h2>
            </div>
            <div class="col-sm-6">
                <a href="/employee?action=create" class="btn btn-success">
                    <span>Thêm mới</span></a>
            </div>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Họ và tên</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Email</th>
            <th scope="col">Địa chỉ</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listEmployee}" var="employee" varStatus="loop">
            <tr>
                <td class="padding">${loop.count}</td>
                <td class="padding"><a
                        href="/employee?action=detail&username=${employee.getUsername()}">${employee.name}</a></td>
                <td class="padding">${employee.phoneNumber}</td>
                <td class="padding">${employee.email}</td>
                <td class="padding">${employee.address}</td>
                <td style="padding-top: 8px">
                    <a href="/employee?action=edit&username=${employee.getUsername()}"
                       class="btn btn-outline-light text-warning">
                        <i class="fas fa-pencil-alt"></i></a>
                </td>
                <td>
                    <c:if test="${employee.getId() !=1}">
                    <button type="button" style="border: none"
                            class="list-group-item list-group-item-action btn btn-outline-light text-danger"
                            data-bs-toggle="modal" data-bs-target="#exampleModal"
                            onclick="modalDelete('${employee.getId()}','${employee.getName()}','${employee.getUsername()}')">
                        <i class="fas fa-trash-alt"></i>
                    </button>
                    </c:if>
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
                <form action="/employee">
                    <input hidden="hidden" name="action" value="delete">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5 text-warning" id="exampleModalLabel">Xác nhận xoá</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input hidden="hidden" name="id" id="idDelete">
                        <input hidden="hidden" name="username" id="usernameDel">
                        Bạn có chắc chắc muốn xoá <span id="deleteName"></span> không?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                        <button type="submit" class="btn">Xoá</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script>
    function modalDelete(id, name, username) {
        document.getElementById("deleteName").innerHTML = name;
        document.getElementById("idDelete").value = id;
        document.getElementById("usernameDel").value = username;
    }
</script>
</html>
