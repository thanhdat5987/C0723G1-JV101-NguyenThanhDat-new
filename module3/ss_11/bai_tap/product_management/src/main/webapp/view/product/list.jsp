<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DS San pham</title>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a href="/product?action=add">Thêm mới</a>
<form action="/product">
    <input hidden="hidden" type="text" name="action" value="find">
    <input type="text" name="name"><button>Tìm sản phẩm</button>
</form>
<table class="table table-stripped">
    <tr>
        <td>Mã sản phẩm</td>
        <td>Tên sản phẩm</td>
        <td>Giá</td>
        <td>Mô tả chi tiết sản phẩm</td>
        <td>Chỉnh sửa</td>
        <td>Chi tiết</td>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>
                <button><a href="/product?action=edit&id=${product.getId()}">Chỉnh sửa</a></button>
                <button><a href="/product?action=delete&id=${product.getId()}">Xoá</a></button>
            </td>
            <td>
                <button><a href="/product?action=view&id=${product.getId()}">Thông tin chi tiết</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
