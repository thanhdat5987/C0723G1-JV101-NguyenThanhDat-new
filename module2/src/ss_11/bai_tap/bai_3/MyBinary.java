package ss_11.bai_tap.bai_3;

import java.util.Scanner;
import java.util.Stack;

public class MyBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to convert to binary: ");
        int myNumber = scanner.nextInt();
        convertToBinary(myNumber);
    }

    public static void convertToBinary(int number) {
        int result = number;
        int binary;
        String binaryString = "";
        Stack<Integer> myStack = new Stack<>();
        do {
            binary = result % 2;
            result = result / 2;
            System.out.println(result);
            myStack.push(binary);
        } while (result != 0);
        int myStackSize = myStack.size();
        for (int i = 0; i < myStackSize; i++) {
            binaryString += myStack.pop();
        }
        System.out.println(number + " convert to binary is: " + binaryString);
    }
}
