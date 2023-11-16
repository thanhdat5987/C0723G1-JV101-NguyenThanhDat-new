<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
    <style>
        th {
            text-align: left
        }
    </style>
</head>
<body>
<h1>Details</h1>
<form:form method="POST" action="saveSetting" modelAttribute="emailConfig">
    <table>
        <tr>
            <th>Languages:</th>
            <td>
                    ${emailConfig.languages}
            </td>
        </tr>
        <tr>
            <th>Page Size:</th>
            <td>
                    ${emailConfig.pageSize}

            </td>
        </tr>
        <tr>
            <th>Spam filter:</th>
            <td>
                    ${emailConfig.spamsFilter}
            </td>
        </tr>
        <tr>
            <th> Signature:</th>
            <td>
                    ${emailConfig.signature}
            </td>
        </tr>
    </table>
</form:form>