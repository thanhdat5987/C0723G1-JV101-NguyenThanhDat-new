package com.example.hien_thi_danh_sach_khach_hang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "CustomerServlet", value = "/customer")

public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Nguyễn Thành Đạt", "01/01/1998","Đà Năng","<a></a>"));
        customerList.add(new Customer("Phạm Thành Hữu", "01/01/1998","Đà Năng","<a></a>"));
        customerList.add(new Customer("Trần Linh Giang", "01/01/1998","Đà Năng","<a></a>"));
        customerList.add(new Customer("Nguyễn Đình Nam", "01/01/1998","Đà Năng","<a></a>"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);
    }
}
