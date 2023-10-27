<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Product discount</title>
</head>
<body>
<form action="/cal" method="post">
    <input name="description" placeholder="Enter Product Description">
    <br>
    <input name="price" placeholder="Enter List Price">
    <br>
    <input name="discount_percent" placeholder="Enter Discount Percent">
    <br>
    <button type="submit">Send</button>
</form>
</body>
</html>