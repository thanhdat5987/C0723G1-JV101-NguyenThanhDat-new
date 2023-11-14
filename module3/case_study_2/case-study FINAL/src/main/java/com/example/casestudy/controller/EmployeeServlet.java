package com.example.casestudy.controller;

import com.example.casestudy.dto.EmployeeDTO;
import com.example.casestudy.model.Account;
import com.example.casestudy.model.Employee;
import com.example.casestudy.service.IAccountService;
import com.example.casestudy.service.IEmployeeService;
import com.example.casestudy.service.impl.AccountService;
import com.example.casestudy.service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private final IEmployeeService employeeService = new EmployeeService();
    private final IAccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                if(account.getRoleId()==3){
                    errorPermiss(req,resp);
                }else {
                showAddForm(req, resp);}
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                if(account.getRoleId()==3){
                    errorPermiss(req,resp);
                }else {
                deleteEmployees(req, resp);}
                break;
            case "search":
                break;
            case "detail":
                detailEmployee(req, resp);
                break;
            default:
                if(account.getRoleId()==3){
                    errorPermiss(req,resp);
                }else {
                listEmployee(req, resp);}
                break;
        }
    }

    private void errorPermiss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("view/home/error.jsp").forward(req, resp);
    }

    private void detailEmployee(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        Employee employee = employeeService.selectEmployeeByUsername(username);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/employee/detail.jsp");
        req.setAttribute("username", username);
        req.setAttribute("employee", employee);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        Employee employee = employeeService.selectEmployeeByUsername(username);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/employee/edit.jsp");
        req.setAttribute("employee", employee);
        req.setAttribute("username", username);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/employee/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest req, HttpServletResponse resp) {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        req.setAttribute("listEmployee", allEmployees);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/employee/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertNewEmployee(req, resp);
                break;
            case "edit":
                updateEmployees(req, resp);
                break;
            default:
                listEmployee(req, resp);
                break;
        }
    }

    private void deleteEmployees(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        int id = Integer.parseInt(req.getParameter("id"));
        employeeService.deleteEmployee(id);
        accountService.deleteAccountByUsername(username);
        try {
            resp.sendRedirect("/employee");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateEmployees(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        Employee employee = employeeService.selectEmployeeByUsername(username);
        employee.setName(req.getParameter("name"));
        employee.setBirthday(Date.valueOf(req.getParameter("birthday")));
        employee.setPhoneNumber(req.getParameter("phoneNumber"));
        employee.setEmail(req.getParameter("email"));
        employee.setAddress(req.getParameter("address"));
        employee.setIdentificationCard(req.getParameter("identificationCard"));
        employee.setSalary(Integer.parseInt(req.getParameter("salary")));
        employeeService.updateEmployee(employee);
        int role = Integer.parseInt(req.getParameter("role"));
        try {
            if (role == 3) {
                resp.sendRedirect("/employee?action=detail&username=" + username);
            } else if (role == 2) {
                resp.sendRedirect("/employee");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertNewEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int role = Integer.parseInt(req.getParameter("role"));
        Account account = new Account(username, password, role);
        accountService.insertAccount(account);
        int id_account = accountService.selectIdAccount(username);
        String name = req.getParameter("name");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String identificationCard = req.getParameter("identificationCard");
        int salary = Integer.parseInt(req.getParameter("salary"));
        String image = req.getParameter("image");
        employeeService.insertEmployee(new Employee(name, birthday, phoneNumber, email, address, identificationCard, salary, image, id_account));
        String mess = "Thêm mới thành công";
        resp.sendRedirect("/employee");
    }
}
