<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<center>
    <h1>User Management</h1>
    <form action="/users">
        <input hidden="hidden" type="text" name="action" value="findByCountry">
        <input type="text" name="name"><button>Find by country</button>
    </form>
    <button><a href="/users?action=create">Add New User</a></button>
    <button><a href="/users?action=sortByName">Sort by name</a></button>
    <button><a href="/users">Cancel Sort</a></button>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>