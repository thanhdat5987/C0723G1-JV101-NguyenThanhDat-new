<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/product">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Ten: </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Gia: </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Mo ta san pham: </td>
                <td>${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/product">Quay lai list san pham</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
