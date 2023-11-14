<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/3/2023
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
                <h2>Quản lý tài khoản</h2>
            </div>
            <div class="col-sm-6">
                <a href="/accounts?action=create" class="btn btn-success">
                    <span>Thêm mới</span></a>
            </div>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tài khoản</th>
            <th scope="col">Role</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${accountList}" var="account" varStatus="loop">
            <tr>
                <td class="padding">${loop.count}</td>
                <td class="padding">${account.getUsername()}</td>
                <td class="padding">${account.getRoles()}</td>
                <c:if test="${account.getRoleId()!=2}">
                <td style="padding-top: 8px">
                    <a href="/accounts?action=edit&id=${account.getAccountId()}"
                       class="btn btn-outline-light text-warning">
                        <i class="fas fa-pencil-alt"></i></a>
                </td>
                <td>
                    <button type="button" style="border: none"
                            class="list-group-item list-group-item-action btn btn-outline-light text-danger"
                            data-bs-toggle="modal" data-bs-target="#exampleModal"
                            onclick="modalDelete('${account.getAccountId()}','${account.getUsername()}')">
                        <i class="fas fa-trash-alt"></i>
                    </button>
                </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--        modal--%>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xoá</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <span> Bạn có muốn xoá account :  </span><span id="deleteName"> </span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <a id="idDelete" class="btn btn-primary">Xoá</a>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<script>
    function modalDelete(id, name) {
        document.getElementById("deleteName").innerText = name;
        document.getElementById("idDelete").setAttribute("href", `/accounts?action=delete&id=` + id);
    }
</script>
</html>