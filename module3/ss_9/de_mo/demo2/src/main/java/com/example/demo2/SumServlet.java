package com.example.demo2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "SumServlet", value = "/sum")
public class SumServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---Do post run----");
        int n1 = Integer.parseInt(req.getParameter("num1"));
        int n2 = Integer.parseInt(req.getParameter("num2"));
        int sum = n1 + n2;
        req.setAttribute("tong", sum);
        req.setAttribute("n1", n1);
        req.setAttribute("n2", n2);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do get run");
        int n1 = Integer.parseInt("num1");
        int n2 = Integer.parseInt("num2");
        int sum = n1 + n2;

    }
}
