package com.example.casestudy.controller;


import com.example.casestudy.model.Pet;
import com.example.casestudy.service.IPetService;
import com.example.casestudy.service.impl.PetService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PetServlet", value = "/pet")
public class PetServlet extends HttpServlet {
private IPetService petService= new PetService();
// doget

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                    deletePetForm(req,resp);
                    break;
                case "edit":
                    showEditFrom(req,resp);
                    break;
                case "search":
                    searchByName(req,resp);
                    break;
                default:
                    listPet(req, resp);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listPet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pet> petList = petService.selectAllPet();
        req.setAttribute("petList", petList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/pet/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        List<Pet> petList = petService.searchByName(name);
        req.setAttribute("petList", petList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/pet/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFrom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        Pet pet = petService.selectPet(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/pet/edit.jsp");
        req.setAttribute("pet", pet);
        dispatcher.forward(req, resp);
    }

    private void deletePetForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        petService.deletePet(id);
        resp.sendRedirect("/pet");
    }


    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/pet/create.jsp");
        requestDispatcher.forward(req,resp);
    }
    // dopost;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action= "";
        }try {
            switch (action){
                case "create":
                    insertPet(req,resp);
                    break;
                case "update":
                    updatePet(req,resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updatePet(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int weight =Integer.parseInt( req.getParameter("weight"));
        String descriptions = req.getParameter("description");
        int id_type_pet= Integer.parseInt(req.getParameter("id_type_pet"));
        int id_customer= Integer.parseInt(req.getParameter("idCustomer"));
        Pet pet = new Pet(id, name, weight, descriptions,id_type_pet,id_customer);
        petService.updatePet(pet);
        resp.sendRedirect("/pet");

    }

    private void insertPet(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String name= req.getParameter("name");
        int weight= req.getIntHeader("weight");
        String descriptions= req.getParameter("descriptions");
        int id_type_pet= req.getIntHeader("id_type_pet");
        int id_customer= req.getIntHeader("id_customer");
        Pet newPet= new Pet(name,weight,descriptions,id_type_pet,id_customer);
        petService.insertPet(newPet);
        resp.sendRedirect("/pet");
    }
}
