package com.example.car.controller;

import com.example.car.model.CarDTO;
import com.example.car.repository.BaseRepository;
import com.example.car.service.ICarService;
import com.example.car.service.impl.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CarServlet", value = "/car-servlet")
public class CarServlet extends HttpServlet {
    private ICarService carService = new CarService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 String action = req.getParameter("action");
 if(action ==null){
     action="";
 }
 switch (action){
     default:
         try {
             listCar(req,resp
             );
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
 }
    }
private void listCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
List<CarDTO> listCar= carService.selectAllCar();
req.setAttribute("lisCar",listCar);
req.getRequestDispatcher("/view/list.jsp").forward(req,resp);

}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
