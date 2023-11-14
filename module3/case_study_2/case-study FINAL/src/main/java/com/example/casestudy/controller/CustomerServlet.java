package com.example.casestudy.controller;


import com.example.casestudy.dto.BookingNamDTO;
import com.example.casestudy.model.Customer;
import com.example.casestudy.service.IBookingService;
import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.impl.BookingService;
import com.example.casestudy.service.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {

    private ICustomerService customerService = new CustomerService();
    private IBookingService bookingService = new BookingService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                formUpdate(request, response);
                break;
            case "history":
                formBookingHistory(request, response);
                break;
            case "detailBooking":
                detailBooking(request, response);
                break;
            default:
                display(request, response);
        }
    }


    private void formUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("customer", customerService.findById(id));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/update_customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void formBookingHistory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customerA= customerService.display(id);
        int idCustomer = customerA.getId();
        request.setAttribute("customer",customerA );
        List<BookingNamDTO> bookingList = customerService.history(idCustomer);
        request.setAttribute("bookingList", bookingList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/history_booking.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void detailBooking(HttpServletRequest request, HttpServletResponse response) {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        List<BookingNamDTO> serviceDetail = bookingService.bookingDetail(bookingId);
        int sumPrice = 0;
        for (BookingNamDTO service:serviceDetail){
            sumPrice+=service.getPriceTotal();
        }
        BookingNamDTO bookingDetail = customerService.detail(bookingId);
        request.setAttribute("sumPrice",sumPrice);
        request.setAttribute("serviceDetail",serviceDetail);
        request.setAttribute("bookingDetail", bookingDetail);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/detail_history.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void display(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("customer", customerService.display(id));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customer_select.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                updateCustomer(request, response);
                break;
            case "searchByName":
                searchByName(request, response);
                break;
            case "remove":
                removeCustomer(request, response);
                break;
            default:
                display(request, response);
        }
    }


    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int accountId = Integer.parseInt(request.getParameter("idAccount"));
        Customer customer = new Customer(id, name, birthday, telephone, email, address, gender);
        String errorName = "Họ tên tối thiếu phải 2 từ và bắt đầu bằng chữ cái viết hoa (Vd: Lý Nam)";
        String errorTelephone = "Số điện thoại bắt đầu phải là (03|05|07|08|09) và gồm 10 số (Vd: 0712389732)";
        String errorEmail = "Email chứa ký tự từ {5;32} và không chứa ký tự đặc biệt trừ ký tự ('_' và '.') cộng @ cộng tên miền  (Vd: nam_123@gmail.com)";
        String errorDob = "Ngày sinh phải nhỏ hơn ngày hiện tại";
        switch (customerService.validateCustomer(name, telephone, email, birthday)) {
            case 1:
                request.setAttribute("customer", customer);
                request.setAttribute("errorName", errorName);
                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("view/customer/update_customer.jsp");
                try {
                    requestDispatcher1.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            case 2:
                request.setAttribute("customer", customer);
                request.setAttribute("errorDob", errorDob);
                RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("view/customer/update_customer.jsp");
                try {
                    requestDispatcher2.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            case 3:
                request.setAttribute("customer", customer);
                request.setAttribute("errorTelephone", errorTelephone);
                RequestDispatcher requestDispatcher3 = request.getRequestDispatcher("view/customer/update_customer.jsp");
                try {
                    requestDispatcher3.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            case 4:
                request.setAttribute("customer", customer);
                request.setAttribute("errorEmail", errorEmail);
                RequestDispatcher requestDispatcher4 = request.getRequestDispatcher("view/customer/update_customer.jsp");
                try {
                    requestDispatcher4.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            case 0:
                boolean check = customerService.updateCustomer(customer);
                try {
                    response.sendRedirect("/customer?id=" + accountId+"&isUpdate="+check);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }

    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String petName = request.getParameter("petName");


    }

    private void removeCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("accountId"));
        customerService.removeCustomer(id);
        try {
            response.sendRedirect("/home?action=logout");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
