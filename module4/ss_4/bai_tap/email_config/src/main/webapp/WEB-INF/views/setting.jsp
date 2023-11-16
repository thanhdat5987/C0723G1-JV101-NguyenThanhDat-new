<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
    <style>
        th {
            text-align: left
        }
        a{
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<h1>Settings</h1>
<form:form method="POST" action="saveSetting" modelAttribute="emailConfig">
    <table>
        <tr>
            <th>Languages:</th>
            <td>
                <form:select path="languages" itemValue="${emailConfig.languages}">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page Size:</th>
            <td>
                Show
                <form:select path="pageSize" itemValue="${emailConfig.pageSize}">
                    <form:options items="${pageSize}"/>
                </form:select> email per page
            </td>
        </tr>
        <tr>
            <th>Spam filter:</th>
            <td>
                <form:checkbox path="spamsFilter" label="Enable spams filter" value="${mailConfig.spamsFilter}"/>
            </td>
        </tr>
        <tr>
            <th> Signature:</th>
            <td>
                <form:textarea path="signature" value="${emailConfig.signature}"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update"/>
                <button><a href="/setting">Cancel</a></button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
