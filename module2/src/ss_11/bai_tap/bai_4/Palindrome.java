package ss_11.bai_tap.bai_4;

import java.sql.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the String that you want to check Palindrome: ");
        String myString = scanner.nextLine();
        checkPalindrome(myString);
    }

    public static void checkPalindrome(String myString) {
        Stack<Character> stringStack = new Stack<>();
        Queue<Character> stringQueue = new LinkedList<>();
        char[] array = new char[myString.length()];
        boolean check = false;
        for (int i = 0; i < myString.length(); i++) {
            stringStack.push(myString.charAt(i));
            stringQueue.add(myString.charAt(i));
        }
        for (int i = 0; i < myString.length(); i++) {

            if (stringStack.pop() == stringQueue.remove()) {
                check = true;
            } else {
                check = false;
            }
        }
        if (check) {
            System.out.println("This is a Palindrome");
        } else {
            System.out.println("This is not a Palindrome");
        }
    }
}
