<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 11/2/23
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <!--    header-->
    <div class="header container-fluid d-flex" style="background: #efcfd4">
        <!-- Logo -->
        <div
                id="logo"
                class="flex-col logo justify-content-center align-items-center d-flex"
        >
            <!-- Header logo -->
            <a href="" title="PET CARE" rel="home">
                <img
                        width="210"
                        height="130"
                        src="https://lh3.googleusercontent.com/pw/ADCreHfMmdaGQ0Nm6dK2wl5fY9BZzyBjvHtGYPplXHh-gdYo35XNQDHL1Mr0_l9bCGZxJhQYWmHg_2e4osTfDhKOrADQuPhAev1Ev1x7Vw6zh7gnAIt_LRrbtL3f4K5Buu3aMyIm2_Jo-M4Vo_VBuehGrOk=w1458-h1458-s-no-gm?authuser=0"
                        class="header_logo header-logo"
                        alt="pet care logo"
                /></a>
        </div>
        <!-- Search -->
        <div class="col-lg-4 justify-content-center align-items-center d-flex">
            <div class="group">
                <svg class="icon" aria-hidden="true" viewBox="0 0 24 24">
                    <g>
                        <path
                                d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z"
                        ></path>
                    </g>
                </svg>
                <input placeholder="Search" type="search" class="input"/>
            </div>
        </div>
        <!-- right -->
        <div class="col-lg-4 justify-content-center align-items-center d-flex">
            <div>
                <c:if test="${account == null}">
                    <a href="/home?action=login">Đăng nhập</a>
                    <a href="/home?action=register">/Đăng kí</a>
                </c:if>
                <c:if test="${account!= null }">
                    <h3>Hello ${sessionScope.account.username}</h3>
                    <div class="dropdown">
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Quản Lý
                        </a>

                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/employee">Quản lý nhân viên</a></li>
                            <li><a class="dropdown-item" href="/employee">Quản lý khách hàng</a></li>
                            <li><a class="dropdown-item" href="/service">Quản lý dịch vụ</a></li>
                            <li><a class="dropdown-item" href="/accounts">Quản lý tài khoản</a></li>
                            <li><a class="dropdown-item" href="/booking-management">Quản lý booking</a></li>
                            <li><a class="dropdown-item" href="/home?action=logout">Đăng xuất</a></li>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
    <div>
        <!-- navbar -->
        <ul class="nav nav-tabs bg-light justify-content-center">
            <li class="nav-item">
                <a class="nav-link " aria-current="page" href="/home"
                >Trang chủ</a
                >
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/home?action=intro">Giới thiệu</a>
            </li>
            <li class="nav-item dropdown">
                <a
                        class="nav-link dropdown-toggle"
                        data-bs-toggle="dropdown"
                        href="#"
                        role="button"
                        aria-expanded="false"
                >Dịch vụ</a
                >
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Cắt tỉa & Spa</a></li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>
                    <li><a class="dropdown-item" href="#">Daycare & Hotel</a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Liên hệ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About pet</a>
            </li>
        </ul>
    </div>
</div>