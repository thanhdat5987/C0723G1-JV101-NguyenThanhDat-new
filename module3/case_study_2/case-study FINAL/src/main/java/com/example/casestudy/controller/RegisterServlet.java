package com.example.casestudy.controller;


import com.example.casestudy.model.Account;
import com.example.casestudy.service.IRegisterService;
import com.example.casestudy.service.impl.RegisterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private final IRegisterService registerService = new RegisterService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                register(req, resp);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            default:
                resp.sendRedirect("/home");
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String numberPhone = req.getParameter("phone");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int gender = Integer.parseInt(req.getParameter("radio"));
        if (registerService.checkUsername(username)) {
            try {
                resp.sendRedirect("view/home/register.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Account account = new Account(username, password);
            registerService.addNewAccount(account);
            int idAccount = registerService.getIdAccount(username);
            registerService.addCustomer(name, birthday, numberPhone, email, address, gender, idAccount);

            try {
                resp.sendRedirect("/home?action=login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }}