<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 31/10/2023
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<c:import url="/navbar.jsp"></c:import>
<h1>Trang danh sách sinh viên</h1>
<a href="/student?action=add">Them moi</a>
<p><%=request.getParameter("mess")%>
</p>
<table class="table table-stripped">
    <tr>
        <td>STT</td>
        <td>Tên</td>
        <td>Giới tính</td>
        <td>Điểm</td>
        <td>Xếp loại</td>
        <td>Mã lớp</td>
        <td>Chỉnh sửa</td>
    </tr>
    <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.name}</td>
            <c:if test="${student.gender}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.gender}">
                <td>Nu</td>
            </c:if>
            <td>${student.point}</td>
            <c:choose>
                <c:when test="${student.point>=8}">
                    <td>Gioi</td>
                </c:when>
                <c:when test="${student.point>=7}">
                    <td>Kha</td>
                </c:when>
                <c:when test="${student.point>=5}">
                    <td>Trung binh</td>
                </c:when>
                <c:otherwise>
                    <td>Yeu</td>
                </c:otherwise>
            </c:choose>
            <td>${student.classId}
            </td>
            <td>
                <button>Chinh sua</button>
                <button>Xoa</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
