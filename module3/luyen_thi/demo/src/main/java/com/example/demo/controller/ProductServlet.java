package com.example.demo.controller;

import com.example.demo.model.ProductDTO;
import com.example.demo.service.IProductService;
import com.example.demo.service.impl.ProductService;

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

@WebServlet(name = "ProductServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                try {
                    listProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }


    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<ProductDTO> productDTOList = productService.selectAllProduct() ;
        req.setAttribute("productList", productDTOList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/product/list.jsp");
        dispatcher.forward(req,resp);
    }
}
