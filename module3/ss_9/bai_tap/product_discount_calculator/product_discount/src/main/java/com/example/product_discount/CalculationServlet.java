package com.example.product_discount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculationServlet", value = "/cal")

public class CalculationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        int discount_percent = Integer.parseInt(req.getParameter("discount_percent"));
        double discount_amount = price * discount_percent * 0.01;
        double discount_price = price - discount_amount;
        req.setAttribute("description", description);
        req.setAttribute("price", price);
        req.setAttribute("discount_percent", discount_percent);
        req.setAttribute("discount_price", discount_price);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(req, resp);
    }
}
