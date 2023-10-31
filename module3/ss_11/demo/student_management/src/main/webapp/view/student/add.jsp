<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 31/10/2023
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới</h1>
<form action="/student?action=add" method="post">
    <input name="id" placeholder="nhap id"><br>
    <input name="name" placeholder="nhap ten"><br>
    <input type="radio" name="gender" value="true">Nam
    <input type="radio" name="gender" value="false">Nu<br>
    <input name="point" placeholder="nhap diem"><br>
    <select name="classId">
        <option value="0">Chon</option>
        <option value="1">C07</option>
        <option value="2">C08</option>
        <option value="3">C09</option>
    </select><br>
    <button type="submit">Luu</button>
</form>
</body>
</html>
