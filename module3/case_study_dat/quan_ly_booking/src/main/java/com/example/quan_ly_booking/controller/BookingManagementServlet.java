package com.example.quan_ly_booking.controller;

import com.example.quan_ly_booking.model.Booking;
import com.example.quan_ly_booking.model.BookingDTO;
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
                case "edit":
                    updateBooking(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateBooking(HttpServletRequest req, HttpServletResponse resp)  throws SQLException, IOException, ServletException{
        int bookingId = Integer.parseInt(req.getParameter("bookingId"));
        int petId = Integer.parseInt(req.getParameter("petId"));
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        String bookingTime = req.getParameter("bookingTime");
        String estimateTimeOfArrival = req.getParameter("estimatedTimeOfArrival");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        int bookingStatusId = Integer.parseInt(req.getParameter("bookingStatusId"));
        Booking editingBooking = new Booking(bookingId,petId,employeeId,bookingTime,estimateTimeOfArrival,startTime,endTime,bookingStatusId);
        bookingService.updateBooking(editingBooking);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void insertBooking(HttpServletRequest req, HttpServletResponse resp)  throws SQLException, IOException, ServletException{
            int petId = Integer.parseInt(req.getParameter("petId"));
            int employeeId = Integer.parseInt(req.getParameter("employeeId"));
            Booking newBooking = new Booking(petId, employeeId);
            bookingService.insertBooking(newBooking);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/create.jsp");
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
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    deleteBooking(req, resp);
                    break;
                default:
                    listBooking(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBooking(HttpServletRequest req, HttpServletResponse resp)  throws SQLException, IOException, ServletException{
        List<BookingDTO> bookingList = bookingService.selectAllBooking();
        req.setAttribute("bookingList", bookingList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteBooking(HttpServletRequest req, HttpServletResponse resp)  throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookingService.deleteBooking(id);
        listBooking(req,resp);
//        List<BookingDTO> listBooking = bookingService.selectAllBooking();
//        req.setAttribute("lbookingList", listBooking);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/list.jsp");
//        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)  throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        Booking existingBooking = bookingService.selectBooking(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/edit.jsp");
        req.setAttribute("editingBooking", existingBooking);
        dispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/booking/create.jsp");
            dispatcher.forward(req, resp);
    }

}