package com.example.ung_dung_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name="CalculatorServlet", value = "/calculator")

public class CalculatorServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(req.getParameter("first-operand"));
        double secondOperand = Double.parseDouble(req.getParameter("second-operand"));
        char operator = req.getParameter("operator").charAt(0);
        try {
            double result = calculate(firstOperand,secondOperand,operator);
            req.setAttribute("result", result);
        } catch (Exception e){
            req.setAttribute( "exception", e.getMessage());
        }
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
    public static double calculate( double firstOperand, double secondOperand, char operator){
        switch (operator){
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new NumberFormatException("Couldn't divide zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
