package com.example.casestudy.controller;


import com.example.casestudy.model.Service;
import com.example.casestudy.service.IServiceService;
import com.example.casestudy.service.impl.ServiceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/service")
public class ServiceServlet extends HttpServlet {
    private IServiceService serviceService = new ServiceService();

    // doGet để hiển thị form;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(req, resp);
                    break;
                case "delete":
                    deleteService(req,resp);
                    break;
                case "edit":
                    showEditFrom(req,resp);
                    break;
                case "search":
                    searchByName(req,resp);
                    break;
                default:
                    listService(req, resp);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteService(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        serviceService.deleteService(id);
        resp.sendRedirect("/service");
    }


    private void searchByName(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        List<Service> serviceList = serviceService.searchByName(name);
        req.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/service/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFrom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Service service = serviceService.selectService(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/service/edit.jsp");
        req.setAttribute("service", service);
        dispatcher.forward(req, resp);
    }
    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/service/create.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void listService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Service> serviceList = serviceService.selectAllService();
        req.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/service/list.jsp");
        dispatcher.forward(req,resp);
    }

    // doPost để thự thi CRUD;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        String action = req.getParameter("action");
        if (action == null){
            action= "";
        }try {
            switch (action){
                case "create":
                    insertService(req,resp);
                    break;
                case "edit":
                    updateService(req,resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateService(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price =Integer.parseInt( req.getParameter("price"));
        String unit = req.getParameter("unit");
        Service service = new Service(id, name, price, unit);
        serviceService.updateService(service);
        resp.sendRedirect("/service");


    }

    private void insertService(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String name= req.getParameter("name");
        int price= Integer.parseInt(req.getParameter("price"));
        String unit= req.getParameter("unit");
        Service newService= new Service(name,price,unit);
        serviceService.insertService(newService);
        resp.sendRedirect("/service");
    }
}