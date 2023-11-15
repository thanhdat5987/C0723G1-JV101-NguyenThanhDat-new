<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 15/11/2023
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <h4>Please choose Condiments</h4>
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts<br>
    <button>Save</button>
</form>
<p>${condimentList}</p>
</body>
</html>
