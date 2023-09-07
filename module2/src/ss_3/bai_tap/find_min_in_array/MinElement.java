package ss_3.bai_tap.find_min_in_array;

import java.util.Scanner;

public class MinElement {
    public static void main(String[] args) {
        int[] array;
        int number;
        Scanner scanner = new Scanner(System.in);
        //Enter Array
        do {
            System.out.print("Enter the number of element of your Array1: ");
            number = scanner.nextInt();
            if (number > 0) {
                break;
            } else {
                System.out.println("Number of element must be geater than 0");
            }
        } while (true);
        array = new int[number];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter value of element " + (i + 1) + " of your array: ");
            array[i] = scanner.nextInt();
        }
        //display array1
        System.out.print("Your array 1 is: ");
        displayArray(array);
        //find mix Element:
        int min = array[0];
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= min) {
                min = array[i];
                index = i;
            }
        }
        System.out.println("Min element is " + min + " at index " + index);
    }

    public static void displayArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
