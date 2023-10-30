package com.example.ung_dung_calculator;

public class Calculator {
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
