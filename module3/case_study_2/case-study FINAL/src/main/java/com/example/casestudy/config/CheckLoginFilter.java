package com.example.casestudy.config;

import com.example.casestudy.model.Account;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CheckLoginFilter", value = {"/service", "/accounts", "/booking-management", "/admin", "/customer", "/employee", "/pet"})
public class CheckLoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        String requestURI = req.getRequestURI();
        if (account == null) {
            resp.sendRedirect("/home?action=login");
            return;
        }
        if (!hasPermission(account.getRoleId(), requestURI)) {
            resp.sendRedirect("view/home/error.jsp");
            return;
        }
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private boolean hasPermission(int roleId, String requestURI) {
        if (roleId == 2) {
            return true;
        } else if (roleId == 3) {
            return requestURI.contains("/admin") || requestURI.contains("/pet") || requestURI.contains("/booking-management")|| requestURI.contains("/employee");
        } else if (roleId == 1) {
            return requestURI.contains("/customer") || requestURI.contains("/booking-management");
        }
        return false;
    }
}
