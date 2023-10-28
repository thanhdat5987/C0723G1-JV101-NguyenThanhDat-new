<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Product discount</title>
</head>
<body>
<form action="/cal" method="post">
    <input type= text name="description" placeholder="Enter Product Description" required>
    <br>
    <input type="number" name="price" placeholder="Enter List Price" required min="0">
    <br>
    <input type="number" name="discount_percent" placeholder="Enter Discount Percent" required min="0">
    <br>
    <button type="submit">Send</button>
</form>
</body>
</html>