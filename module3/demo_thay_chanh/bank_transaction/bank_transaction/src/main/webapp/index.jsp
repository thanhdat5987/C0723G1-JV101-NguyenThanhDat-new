<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
        nav {
            background-color: #7952B3;
        }

        .nav-link {
            color: orange !important;
        }

        .left {
            border: 1px solid #7952B3;
            padding: 0;
        }

        .main {
            height: 90%;
            margin-top: 4.5%;
        }

        ::-webkit-scrollbar {
            opacity: 0;
            width: 5px;
        }

        ::-webkit-scrollbar-thumb:hover {
            opacity: 1;
            background-color: #7952B3;
        }

        .icon:hover {
            transform: scale(2.0);
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-sm fixed-top">
        <div class="container-fluid d-flex justify-content-start align-items-center">
            <a class="navbar-brand icon" href="#">
                <img width="25" height="25" src="https://img.icons8.com/emoji/48/bouquet-emoji.png"
                     alt="bouquet-emoji"/>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="text-white">Menu</span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="color: white" class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled">Disabled</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control form-control-sm me-2" type="search" placeholder="Search"
                           aria-label="Search">
                    <button class="btn btn-outline-warning btn-sm" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    <div class="row  main">
        <div class="col-s-12 col-sm-4 col-md-2 left">
            <div class="min-vh-100 navbar-nav-scroll">
                <button class="btn btn-link w-100 text-start" style="color: #7952B3;font-weight: bold"
                        data-bs-toggle="collapse" data-bs-target="#tree1">
                    <img  width="20" height="15" src="https://img.icons8.com/material/24/more-than--v1.png" alt="more-than--v1"/>Sam sung</button>
                <ul class="list-group collapse" id="tree1">
                    <li class="list-group-item disabled" aria-disabled="true">A disabled item</li>
                    <li class="list-group-item">A second item</li>
                    <li class="list-group-item">A third item</li>
                    <li class="list-group-item">A fourth item</li>
                    <li class="list-group-item">And a fifth one</li>
                </ul>
                <button class="btn btn-link w-100 text-start" data-bs-toggle="collapse" data-bs-target="#tree2">Nokia</button>
                <ul class="list-group collapse" id="tree2">
                    <li class="list-group-item disabled" aria-disabled="true">A disabled item</li>
                    <li class="list-group-item">A second item</li>
                    <li class="list-group-item">A third item</li>
                    <li class="list-group-item">A fourth item</li>
                    <li class="list-group-item">And a fifth one</li>
                </ul>
                <button class="btn btn-link w-100 text-start" data-bs-toggle="collapse" data-bs-target="#tree3">Nokia</button>
                <ul class="list-group collapse" id="tree3">
                    <li class="list-group-item disabled" aria-disabled="true">A disabled item</li>
                    <li class="list-group-item">A second item</li>
                    <li class="list-group-item">A third item</li>
                    <li class="list-group-item">A fourth item</li>
                    <li class="list-group-item">And a fifth one</li>
                </ul>
                <button class="btn btn-link w-100 text-start" data-bs-toggle="collapse" data-bs-target="#tree4">Nokia</button>
                <ul class="list-group collapse" id="tree4">
                    <li class="list-group-item disabled" aria-disabled="true">A disabled item</li>
                    <li class="list-group-item">A second item</li>
                    <li class="list-group-item">A third item</li>
                    <li class="list-group-item">A fourth item</li>
                    <li class="list-group-item">And a fifth one</li>
                </ul>
            </div>
        </div>
        <div class="col-s-12 col-sm-8 col-md-10">
            <div class="row my-2">
                <a href="/transfer" class="btn btn-warning">Chuyển khoản</a>
                <c:if test="${message!=null}">
                    <p style="color: red">${message}</p>
                </c:if>
            </div>
        </div>
    </div>
</div>
<script>
    <%--function displayToast(mess){--%>
    <%--    document.getElementById("toast-content").innerText= mess;--%>
    <%--    let toastEl = document.getElementById("toast");--%>
    <%--    let toast = new bootstrap.Toast(toastEl);--%>
    <%--    toast.show();--%>
    <%--}--%>
    <%--<c:if test="${message}">--%>
    <%--displayToast("Thêm mới thành công");--%>
    <%--</c:if>--%>
</script>
</body>
</html>