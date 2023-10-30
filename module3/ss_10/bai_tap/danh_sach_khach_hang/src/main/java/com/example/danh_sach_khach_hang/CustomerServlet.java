package com.example.danh_sach_khach_hang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="CustomerServlet", value="/customer")
public class CustomerServlet extends HttpServlet {
    private final static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Nguyễn Thành Đạt", "01/01/1998","Đà Năng","https://boxgaixinh.net/wp-content/uploads/2023/02/avatar-dep-ngau-nu-3.jpg"));
        customerList.add(new Customer("Phạm Thành Hữu", "01/01/1998","Đà Năng","https://boxgaixinh.net/wp-content/uploads/2023/02/avatar-dep-ngau-nu-9.jpg"));
        customerList.add(new Customer("Trần Linh Giang", "01/01/1998","Đà Năng","https://boxgaixinh.net/wp-content/uploads/2023/02/avatar-dep-ngau-nu-1.jpg"));
        customerList.add(new Customer("Nguyễn Đình Nam", "01/01/1998","Đà Năng","https://boxgaixinh.net/wp-content/uploads/2023/02/avatar-dep-ngau-nu-2.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customerList", customerList );
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
