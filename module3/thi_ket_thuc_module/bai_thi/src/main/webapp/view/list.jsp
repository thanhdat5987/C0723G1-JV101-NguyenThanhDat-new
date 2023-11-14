<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 10/11/2023
  Time: 04:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quan ly</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        /*a {*/
        /*    text-decoration: none;*/
        /*    color: white;*/
        /*}*/

        /*h2 {*/
        /*    padding-top: 20px;*/
        /*    padding-bottom: 20px;*/
        /*}*/
    </style>
</head>
<body>
<div class="container">
    <h1>Quản Lý </h1>
    <a class="btn btn btn-primary " href="">Tạo mới vé</a>
    <h2 style="text-align: center">Danh sách phạt vi phạm nội quy nuôi thú cưng</h2>
    <br>
    <table class="table table-primary table-striped ">
        <thead>
        <tr>
            <th>Mã vé phạt</th>
            <th>Tên tài khoản</th>
            <th>Số Đk thú nuôi</th>
            <th>Lỗi vi phạm</th>
            <th>Ngày giờ vi phạm</th>
            <th>Số tiền phạt</th>
            <th>Chức năng</th>
        </tr>
        </thead>
        <c:forEach var="infor" items="${informationList}">
            <tr>
                <td>${infor.informationCode}</td>
                <td>${infor.accountName}</td>
                <td>${infor.petCode}</td>
                <td>${infor.detail}</td>
                <td>${infor.date}</td>
                <td>${infor.payment}</td>
                <td>
                    <a class="btn btn-danger" href="">Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
