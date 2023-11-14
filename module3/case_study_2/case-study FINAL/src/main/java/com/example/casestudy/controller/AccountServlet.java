package com.example.casestudy.controller;


import com.example.casestudy.dto.AccountDto;
import com.example.casestudy.model.Account;
import com.example.casestudy.model.Role;
import com.example.casestudy.service.IAccountService;
import com.example.casestudy.service.impl.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {
    private final IAccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                deleteAccount(req,resp);
                break;
            default:
                listAccounts(req, resp);
                break;
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        RequestDispatcher requestDispatcher = null;
        Account account = accountService.selectAccount(id);
        List<Role> roleList = accountService.selectRole();
        req.setAttribute("account", account);
        req.setAttribute("roleList", roleList);
        requestDispatcher = req.getRequestDispatcher("view/accounts/edit.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {

        List<Role> roleList = accountService.selectRole();
        req.setAttribute("roleList", roleList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/accounts/createaccount.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listAccounts(HttpServletRequest req, HttpServletResponse resp) {
        List<AccountDto> accountDtoList = accountService.selectAllAccount();
        String msg = req.getParameter("msg");
        req.setAttribute("msg", msg);
        req.setAttribute("accountList", accountDtoList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/accounts/list.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteAccount(HttpServletRequest req, HttpServletResponse resp) {
        int id  = Integer.parseInt(req.getParameter("id"));
        accountService.deleteAccount(id);
        try {
            resp.sendRedirect("/accounts");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertAccount(req, resp);
                break;
            case "edit":
                editAccount(req,resp);
                break;
        }
    }

    private void editAccount(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        Account account = accountService.selectAccount(id);
        account.setRoleId(roleId);
        accountService.updateAccount(account);
        try {
            resp.sendRedirect("/accounts");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertAccount(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int roleId = Integer.parseInt(req.getParameter("roles"));
        Account account = new Account(username, password,roleId);
        accountService.insertAccount(account);
        try {
            resp.sendRedirect("/accounts");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}