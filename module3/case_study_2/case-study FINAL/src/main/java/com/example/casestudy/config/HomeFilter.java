package com.example.casestudy.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class HomeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String url = req.getServletPath();
        if(url.endsWith(".jsp")){
            resp.sendRedirect("/home");
            return;
        }
        try {
         chain.doFilter(request,response);
        }catch (Throwable t){
            t.printStackTrace();
        }

    }
}
