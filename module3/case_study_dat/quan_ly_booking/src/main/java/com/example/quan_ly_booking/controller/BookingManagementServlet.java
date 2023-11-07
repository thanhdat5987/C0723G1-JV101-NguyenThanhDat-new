package com.example.quan_ly_booking.controller;

import com.example.quan_ly_booking.model.*;
import com.example.quan_ly_booking.service.IBookingService;
import com.example.quan_ly_booking.service.impl.BookingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookingServlet", urlPatterns = "/booking-management")
public class BookingManagementServlet extends HttpServlet {
    private IBookingService bookingService = new BookingService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertBooking(req, resp);
                    break;
                case "createBookingOnline":
                    insertCustomerBooking(req, resp);
                    break;
                case "edit":
                    updateBooking(req, resp);
                    break;
                case "addingDetailService":
                    addDetailService(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateBooking(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int bookingId = Integer.parseInt(req.getParameter("bookingId"));
        int petId = Integer.parseInt(req.getParameter("petId"));
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        String bookingTime = req.getParameter("bookingTime");
        String estimateTimeOfArrival = req.getParameter("estimatedTimeOfArrival");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        int bookingStatusId = Integer.parseInt(req.getParameter("bookingStatusId"));
        Booking editingBooking = new Booking(bookingId, petId, employeeId, bookingTime, estimateTimeOfArrival, startTime, endTime, bookingStatusId);
        bookingService.updateBooking(editingBooking);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void insertBooking(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int petId = Integer.parseInt(req.getParameter("petId"));
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        Booking newBooking = new Booking(petId, employeeId);
        bookingService.insertBooking(newBooking);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/create.jsp");
        dispatcher.forward(req, resp);
    }
    private void addDetailService(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int bookingId = Integer.parseInt(req.getParameter("bookingId"));
        int serviceId = Integer.parseInt(req.getParameter("serviceId"));
        int quantity= Integer.parseInt(req.getParameter("quantity"));
        DetailService detailService = new DetailService(bookingId,serviceId, quantity);
        bookingService.insertDetailService(detailService);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/adding-detail-service.jsp");
        dispatcher.forward(req, resp);
    }
    private void insertCustomerBooking(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int petId = Integer.parseInt(req.getParameter("petId"));
        String estimatedTimeOfArrival = req.getParameter("estimatedTimeOfArrival");
        String customerComment = req.getParameter("customerComment");
        Booking newBooking = new Booking(petId, estimatedTimeOfArrival, customerComment);
        bookingService.insertCustomerBooking(newBooking);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/booking-customer.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(req, resp);
                    break;
                case "createBookingOnline":
                    showNewOnlineForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    deleteBooking(req, resp);
                    break;
                case "addingDetailService":
                    showAddingDetailServiceForm(req, resp);
                    break;
                case "listDetailService":
                    listDetailService(req, resp);
                    break;
                case "detailService":
                    showDetailService(req, resp);
                    break;
                default:
                    listBooking(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBooking(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        List<BookingDTO> bookingList = bookingService.selectAllBooking();
        req.setAttribute("bookingList", bookingList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteBooking(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookingService.deleteBooking(id);
        listBooking(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<BookingStatus> bookingStatusList = bookingService.selectBookingStatus();
        List<Employee> employeeList = bookingService.selectEmployeelist();
        Booking existingBooking = bookingService.selectBooking(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/edit.jsp");
        req.setAttribute("editingBooking", existingBooking);
        req.setAttribute("bookingStatusList", bookingStatusList);
        req.setAttribute("employeeList", employeeList);
        dispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        List<Employee> employeeList = bookingService.selectEmployeelist();
        List<Pet> petList = bookingService.selectPetList();
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/create.jsp");
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("petList", petList);
        dispatcher.forward(req, resp);
    }

    private void showNewOnlineForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        List<Pet> petList = bookingService.selectPetOfCustomerList();
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/booking-customer.jsp");
        req.setAttribute("petList", petList);
        dispatcher.forward(req, resp);
    }

    private void showAddingDetailServiceForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Booking existingBooking = bookingService.selectBooking(id);
        List<Service> serviceList = bookingService.selectServiceList();
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/adding-detail-service.jsp");
        req.setAttribute("existingBooking", existingBooking);
        req.setAttribute("serviceList", serviceList);
        dispatcher.forward(req, resp);
    }
    private void listDetailService(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<DetailServiceBookingDTO> detailServiceList = bookingService.selectDetailServiceList(id);
        req.setAttribute("detailServiceList", detailServiceList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/show-detail-service.jsp");
        dispatcher.forward(req, resp);
    }

    private void showDetailService(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        DetailServiceDTO detailService = bookingService.selectDetailService(id);
        req.setAttribute("detailService", detailService);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/show-detail-service-by-id.jsp");
        dispatcher.forward(req, resp);
    }
}