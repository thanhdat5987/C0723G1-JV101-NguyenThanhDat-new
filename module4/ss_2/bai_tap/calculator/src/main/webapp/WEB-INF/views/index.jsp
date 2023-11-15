<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 15/11/2023
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calculate</title>
</head>
<body>
<form action="/calculate" method="post">
    <h2>Calculator</h2>
    <input type="number" placeholder="please enter a number" name="number1" required>
    <input type="number" placeholder="please enter a number" name="number2" required><br>
    <button name="operator" value="+">Addition(+)</button>
    <button name="operator" value="-">Subtraction(-)</button>
    <button name="operator" value="*">Multiplication(x)</button>
    <button name="operator" value="/">Division(/)</button>
</form>
<h2>${result} ${message}</h2>
</body>
</html>
