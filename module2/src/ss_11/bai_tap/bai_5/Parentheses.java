package ss_11.bai_tap.bai_5;

import java.util.Scanner;
import java.util.Stack;

public class Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a math string with parentheses to check: ");
        String mathString = scanner.nextLine();
        if (checkParentheses(mathString)) {
            System.out.println("Well");
        } else {
            System.out.println("Wrong");
        }
    }

    public static boolean checkParentheses(String mathString) {
        Stack<Character> parenthesesStack = new Stack<>();
        String leftParenthesis = "";
        String rightParenthesis = "";
        for (int i = 0; i < mathString.length(); i++) {
            if (String.valueOf(mathString.charAt(i)).equals("(")) {
                parenthesesStack.push(mathString.charAt(i));
            }
            if (String.valueOf(mathString.charAt(i)).equals(")")) {
                if (parenthesesStack.empty()) {
                    return false;
                } else {
                    rightParenthesis += ")";
                    leftParenthesis += String.valueOf(parenthesesStack.pop());
                }
            }
        }
        if (leftParenthesis.length() != rightParenthesis.length()) {
            return false;
        }
        return true;
    }
}

