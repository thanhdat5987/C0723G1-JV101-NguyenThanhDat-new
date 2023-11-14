package com.example.casestudy.controller;


import com.example.casestudy.dto.AccountDto;
import com.example.casestudy.model.Account;
import com.example.casestudy.model.Customer;
import com.example.casestudy.service.IAccountService;
import com.example.casestudy.service.ICustomerAdminService;
import com.example.casestudy.service.impl.AccountService;
import com.example.casestudy.service.impl.CustomerAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CustomerAdminServlet", value = "/admin")
public class CustomerAdminServlet extends HttpServlet {
    private ICustomerAdminService customerAdminServlet = new CustomerAdminService();
    private IAccountService accountService = new AccountService();

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
            case "create":
                formCreate(request, response);
                break;
            default:
                display(request, response);
        }
    }


    private void display(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerList", customerAdminServlet.display());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/select_admin.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void formCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void formUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerAdminServlet.findById(id);
        request.setAttribute("customer",customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/update_admin.jsp");
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
            case "create":
                create(request, response);
                break;
            case "remove":
                removeCustomer(request, response);
                break;
            default:
                display(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int gender = Integer.parseInt(request.getParameter("gender"));
//        đối tượng account
        Account accountC = new Account(username, password);
        Customer customer = new Customer(name, birthday, telephone, email, address, gender);
        String doubleUsername="Tên đăng nhập đã tồn tại";
        String errorUsername="Tên đăng nhập không được chứa ký tự đặc biệt, không chứa dấu cách và tối thiểu 5 ký tự (Vd nam123)";
        String errorPassword="Mật khẩu tối thiểu phải có 1 chữ viết hoa, viết thường và số, không chứa dấu cách và tối thiểu 8 ký tự  (Vd Nam345)";
        String errorConfirmPassword="Xác nhận mật khẩu không đúng";
        String errorName = "Họ tên tối thiếu phải 2 từ và bắt đầu bằng chữ cái viết hoa (Vd: Lý Nam)";
        String errorTelephone = "Số điện thoại bắt đầu phải là (03|05|07|08|09) và gồm 10 số (Vd: 0712389732)";
        String errorEmail = "Email chứa ký tự từ {5;32} và không chứa ký tự đặc biệt trừ ký tự ('_' và '.') cộng @ cộng tên miền  (Vd: nam_123@gmail.com)";
        String errorDob = "Ngày sinh phải nhỏ hơn ngày hiện tại";
        List<AccountDto> accountList = accountService.selectAllAccount();
        for (AccountDto account:accountList){
            if (account.getUsername().equals(username)){
                request.setAttribute("doubleUsername",doubleUsername);
                request.setAttribute("confirmPassword",confirmPassword);
                request.setAttribute("customer", customer);
                request.setAttribute("accountC", accountC);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
                try {
                    requestDispatcher.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }

        if (customerAdminServlet.validateAccount(username,password)==1){
            request.setAttribute("errorUsername",errorUsername);
            request.setAttribute("confirmPassword",confirmPassword);
            request.setAttribute("customer", customer);
            request.setAttribute("accountC", accountC);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (customerAdminServlet.validateAccount(username,password)==2) {
            request.setAttribute("errorPassword",errorPassword);
            request.setAttribute("confirmPassword",confirmPassword);
            request.setAttribute("customer", customer);
            request.setAttribute("accountC", accountC);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (!password.equals(confirmPassword)) {
            request.setAttribute("errorConfirmPassword",errorConfirmPassword);
            request.setAttribute("confirmPassword",confirmPassword);
            request.setAttribute("customer", customer);
            request.setAttribute("accountC", accountC);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create_customer.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            switch (customerAdminServlet.validateCustomer(name, telephone, email, birthday)) {
                case 1:
                    request.setAttribute("customer", customer);
                    request.setAttribute("errorName", errorName);
                    request.setAttribute("confirmPassword",confirmPassword);
                    request.setAttribute("accountC", accountC);
                    RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("view/customer/create_customer.jsp");
                    try {
                        requestDispatcher1.forward(request, response);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    request.setAttribute("confirmPassword",confirmPassword);
                    request.setAttribute("customer", customer);
                    request.setAttribute("errorDob", errorDob);
                    request.setAttribute("accountC", accountC);
                    RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("view/customer/create_customer.jsp");
                    try {
                        requestDispatcher2.forward(request, response);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    request.setAttribute("confirmPassword",confirmPassword);
                    request.setAttribute("customer", customer);
                    request.setAttribute("errorTelephone", errorTelephone);
                    request.setAttribute("accountC", accountC);
                    RequestDispatcher requestDispatcher3 = request.getRequestDispatcher("view/customer/create_customer.jsp");
                    try {
                        requestDispatcher3.forward(request, response);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    request.setAttribute("confirmPassword",confirmPassword);
                    request.setAttribute("customer", customer);
                    request.setAttribute("errorEmail", errorEmail);
                    request.setAttribute("accountC", accountC);
                    RequestDispatcher requestDispatcher4 = request.getRequestDispatcher("view/customer/create_customer.jsp");
                    try {
                        requestDispatcher4.forward(request, response);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 0:
                    //        tạo account
                    customerAdminServlet.saveAccount(accountC);
                    int idAccount = customerAdminServlet.searchIdAccount(username);
                    Account accountCreate = new Account(idAccount);
                    Customer customerCreate = new Customer(name, birthday, telephone, email, address, gender, accountCreate);
                    boolean check= customerAdminServlet.saveCustomer(customerCreate);
                    try {
                        response.sendRedirect("/admin?isCreated="+check);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
        }

    }

    private void removeCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check=customerAdminServlet.delete(id);
        try {
            response.sendRedirect("/admin?isDelete="+check);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
//        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
//        Account account = new Account(idAccount);
        Customer customer = new Customer(id, name, birthday, telephone, email, address, gender);
        String errorName = "Họ tên tối thiếu phải 2 từ và bắt đầu bằng chữ cái viết hoa (Vd: Lý Nam)";
        String errorTelephone = "Số điện thoại bắt đầu phải là (03|05|07|08|09) và gồm 10 số (Vd: 0712389732)";
        String errorEmail = "Email chứa ký tự từ {5;32} và không chứa ký tự đặc biệt trừ ký tự ('_' và '.') cộng @ cộng tên miền  (Vd: nam_123@gmail.com)";
        String errorDob = "Ngày sinh phải nhỏ hơn ngày hiện tại";
        switch (customerAdminServlet.validateCustomer(name, telephone, email, birthday)) {
            case 1:
                request.setAttribute("customer", customer);
                request.setAttribute("errorName", errorName);
                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("view/customer/update_admin.jsp");
                try {
                    requestDispatcher1.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                request.setAttribute("customer", customer);
                request.setAttribute("errorDob", errorDob);
                RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("view/customer/update_admin.jsp");
                try {
                    requestDispatcher2.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                request.setAttribute("customer", customer);
                request.setAttribute("errorTelephone", errorTelephone);
                RequestDispatcher requestDispatcher3 = request.getRequestDispatcher("view/customer/update_admin.jsp");
                try {
                    requestDispatcher3.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 4:
                request.setAttribute("customer", customer);
                request.setAttribute("errorEmail", errorEmail);
                RequestDispatcher requestDispatcher4 = request.getRequestDispatcher("view/customer/update_admin.jsp");
                try {
                    requestDispatcher4.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 0:
                boolean check = customerAdminServlet.updateCustomer(customer);
                try {
                    response.sendRedirect("/admin?isUpdate="+check);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }

}
