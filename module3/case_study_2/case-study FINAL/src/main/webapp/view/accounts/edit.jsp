<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 11/4/2023--%>
<%--  Time: 16:21--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <title>Edit User</title>--%>
<%--  <style>--%>
<%--    <jsp:include page="../css/edit.css"/>--%>
<%--  </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Edit User</h2>--%>
<%--<form method="post">--%>
<%--  <table>--%>
<%--    <tr>--%>
<%--      <th>Username</th>--%>
<%--      <td>${account.getUsername()}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--      <th>Roles</th>--%>
<%--      <td>--%>
<%--        <select name="roleId" id="roles">--%>
<%--          <c:forEach items="${roleList}" var="role">--%>
<%--            <option value="${role.getIdRole()}">--%>
<%--                ${role.getRoles()}--%>
<%--            </option>--%>
<%--          </c:forEach>--%>
<%--        </select>--%>
<%--      </td>--%>
<%--    </tr>--%>
<%--  </table>--%>
<%--  <button type="submit">Edit</button>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Chỉnh sửa thông tin tài khoản</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        <jsp:include page="../css/header.css"/>
    </style>
</head>
<body>
<div>
    <jsp:include page="../home/navbar.jsp"/>

    <div class="container">
        <div class="row mt-5">
            <div class="col-lg-9 col-12 right row " id="right">
                <div>
                    <h2 class="mb-3 mt-3" style="">Thông tin tài khoản</h2>
                </div>
                <form method="post">
                    <div class="border row">
                        <div class="col-lg-3 col-md-5 col-12 mb-3">
                            <input class="form-control-plaintext " disabled value="Tài khoản:"/>
                        </div>
                        <div class="col-lg-9 col-md-7 col-12 mb-3">
                            <input name="username" class="form-control-plaintext" value="${account.getUsername()}"/>
                        </div>
                    </div>
                    <div class="border row">
                        <div class="col-lg-3 col-md-5 col-12 mb-3">
                            <input class="form-control-plaintext " disabled value="Roles:"/>
                        </div>
                        <div class="col-lg-9 col-md-7 col-12 mb-3">
                            <select name="roleId" id="roles">
                                <c:forEach items="${roleList}" var="role">
                                    <option value="${role.getIdRole()}">
                                            ${role.getRoles()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="row mt-2" style="text-align: center">
                        <div class="col-6">
                            <a href="/employee" class="btn btn-warning">Quay lại</a>
                        </div>
                        <div class="col-6">
                            <input hidden="hidden" name="role" value="${sessionScope.account.roleId}"/>
                            <input type="submit" value="Lưu"/>
                        </div>
                    </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
