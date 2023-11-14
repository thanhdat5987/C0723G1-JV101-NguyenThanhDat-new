package com.example.bai_thi.controller;

import com.example.bai_thi.model.InformationDTO;
import com.example.bai_thi.service.IInformationService;
import com.example.bai_thi.service.impl.InformationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "InformationServlet", urlPatterns = "/information")
public class InformationServlet extends HttpServlet {
 IInformationService informationService = new InformationService();
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
                    listInformation(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void listInformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<InformationDTO> informationDTOList = informationService.listInformation();
        req.setAttribute("informationList",informationDTOList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/list.jsp");
        requestDispatcher.forward(req,resp);
    }
}
