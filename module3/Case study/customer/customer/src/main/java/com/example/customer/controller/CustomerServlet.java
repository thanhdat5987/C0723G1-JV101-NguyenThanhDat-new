package com.example.customer.controller;

import com.example.customer.model.Account;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.example.customer.service.ICustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private final String REGEX_NAME = "^([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){1,})$";
    private final String REGEX_TELEPHONE = "^0(3|5|7|8|9)\\d{8}$";
    private ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "update":
                formUpdate(request,response);
                break;
            default:
                display(request,response);
        }
    }

    private void formUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("customer",customerService.findById(id));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update_customer.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void display(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customer",customerService.display());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer_select.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "update":
                updateCustomer(request,response);
                break;
            default:
                display(request,response);
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        System.out.println(birthday);
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        Account account = new Account(idAccount);

        if (name.toLowerCase().matches(REGEX_NAME) && telephone.matches(REGEX_TELEPHONE)){
            Customer customer = new Customer(id,name,birthday,telephone,email,address,gender,account);
            customerService.updateCustomer(customer);
            display(request,response);
        }else {
            Boolean flag = false;
            request.setAttribute("flag",flag);
            formUpdate(request,response);
        }

    }
}
