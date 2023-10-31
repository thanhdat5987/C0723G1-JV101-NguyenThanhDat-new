<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h1>Thêm mới sản phẩm</h1>
<form action="/product?action=add" method="post">
    <input name="id" placeholder="nhap id san pham"><br>
    <input name="name" placeholder="nhap ten san pham"><br>
    <input name="price" placeholder="nhap gia san pham"><br>
    <input name="description" placeholder="nhap thong tin chi tiet"><br>
    <button type="submit">Lưu</button>
</form>
</body>
</html>
