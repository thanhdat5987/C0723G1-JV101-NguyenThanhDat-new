<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 14/11/2023
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Conversion</title>
</head>
<body>
<h1>Currency Conversion</h1>
<form method="post">
    <input type="number" name="rate" placeholder="Enter Current Rate">
    <input type="number" name="usdAmount" placeholder="Enter USD amount">
    <button>Submit</button>
    <p>Result :  ${usdAmount} USD = ${result} VND</p>
    <br>
</form>
</body>
</html>
