package ss_11.bai_tap.bai_1;

import java.util.Arrays;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        //reverse array
        int[] myArray = {1, 2, 3, 4, 5};
        reverseArrayNumber(myArray);
        //reverse string
        String myWord = "hello world";
        reverseString(myWord);
    }

    public static void reverseArrayNumber(int[] myArray) {
        Stack<Integer> myStack = new Stack<>();
        for (int i = 0; i < myArray.length; i++) {
            myStack.push(myArray[i]);
        }
        for (int j = 0; j < myArray.length; j++) {
            myArray[j] = myStack.pop();
        }
        System.out.println(Arrays.toString(myArray));
    }

    public static void reverseString(String myWord) {
        String myNewWord = "";
        Stack<Character> myWordStack = new Stack<>();
        for (int i = 0; i < myWord.length(); i++) {
            myWordStack.push(myWord.charAt(i));
        }
        for (int i = 0; i < myWord.length(); i++) {
            myNewWord += myWordStack.pop();
        }
        System.out.println(myNewWord);
    }
}
