<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xem chi tiet san pham</title>
</head>
<body>
<h1>Chi tiet san pham</h1>
<p>
    <a href="/product">Quay lai list san pham</a>
</p>
<table>
    <tr>
        <td>Ten san pham: </td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Gia san pham: </td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
    <tr>
        <td>Chi tiet san pham: </td>
        <td>${requestScope["product"].getDescription()}</td>
    </tr>
</table>
</body>
</html>
