package com.example.user_management.controller;

import com.example.user_management.model.User;
import com.example.user_management.service.IUserService;
import com.example.user_management.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();

    public void init() {
        userService = new UserService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "findByCountry":
                    showFindingResultForm(request, response);
                    break;
                case "sortByName":
                    listUserSortingByName(request, response);
                    break;
                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;
                case "test-use-tran":

                    testUseTran(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userService.selectAllUserStore();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listUserSortingByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUserSorting = userService.sortUsersByName();
        request.setAttribute("listUser", listUserSorting);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //User existingUser = userService.selectUser(id);
        User existingUser = userService.getUserById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void showFindingResultForm(HttpServletRequest req, HttpServletResponse resp) {
        String country = req.getParameter("name");
        List<User> userList = userService.findByCountry(country);
        RequestDispatcher dispatcher;
        if (userList == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("userList", userList);
            dispatcher = req.getRequestDispatcher("view/user/findByCountry.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String add = request.getParameter("add");
        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");
        String view = request.getParameter("view");
        List<Integer> permissions = new ArrayList<>();
        if (add != null){
            permissions.add(1);
        }
        if (edit != null){
            permissions.add(2);
        }
        if (delete != null){
            permissions.add(3);
        }
        if (view != null){
            permissions.add(4);
        }

        User newUser = new User(name, email, country);
        userService.addUserTransaction(newUser, permissions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User book = new User(id, name, email, country);
        userService.updateUserStore(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUserStore(id);
        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }
    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateWithoutTransaction();
    }
    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {

        userService.insertUpdateUseTransaction();

    }
}
