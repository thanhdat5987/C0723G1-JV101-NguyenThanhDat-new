package com.example.casestudy.controller;

import com.example.casestudy.model.Account;
import com.example.casestudy.service.IAccountService;
import com.example.casestudy.service.impl.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    private final IAccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "intro":
                intro(req, resp);
                break;
            case "login":
                loginUserForm(req, resp);
                break;
            case "logout":
                logOutUser(req, resp);
                break;
            case "register":
                registerUserForm(req, resp);
                break;
            case "service":
                introService(req, resp);
                break;
            default:
                home(req, resp);
                break;
        }
    }

    private void introService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/home/introduceService.jsp");
        dispatcher.forward(req, resp);
    }

    private void logOutUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("account");
        resp.sendRedirect("/home");
    }

    private void loginUserForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/home/login.jsp");
        dispatcher.forward(req, resp);
    }

    private void registerUserForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/home/register.jsp");
        dispatcher.forward(req, resp);
    }

    private void intro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/home/introductionStore.jsp");
        dispatcher.forward(req, resp);
    }

    private void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/home/mainHome.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                loginUser(req, resp);
                break;
            case "register":
                registerUser(req, resp);
                break;
            case "employee":
                employee(req, resp);
                break;
            default:
                home(req, resp);
                break;
        }
    }

    private void employee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/employee");
    }

    private void registerUser(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("rem");
        Cookie cookieUser = new Cookie("cookieUser", username);
        Cookie cookiePass = new Cookie("cookiePass", password);
        Cookie cookieRem = new Cookie("cookieRem", remember);
        Account account = accountService.check(username, password);
        if (remember != null) {
            cookieRem.setMaxAge(60 * 60 * 24);
            cookieUser.setMaxAge(60 * 60 * 24 * 3);
            cookiePass.setMaxAge(60 * 60 * 24);
        } else {
            cookieRem.setMaxAge(0);
            cookieUser.setMaxAge(0);
            cookiePass.setMaxAge(0);
        }
        resp.addCookie(cookieUser);
        resp.addCookie(cookiePass);
        resp.addCookie(cookieRem);
        if (account == null) {
            req.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng !!!");
            req.getRequestDispatcher("view/home/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("account", account);
            req.getRequestDispatcher("view/home/mainHome.jsp").forward(req, resp);
        }
    }
}
