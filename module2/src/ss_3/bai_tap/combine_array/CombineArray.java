package ss_3.bai_tap.combine_array;

import java.util.Scanner;

public class CombineArray {
    public static void main(String[] args) {
        int number1;
        int number2;
        int number;
        int[] array1;
        int[] array2;
        int[] combineArray;
        Scanner scanner = new Scanner(System.in);
        //Enter Array1
        do {
            System.out.print("Enter the number of element of your Array1: ");
            number1 = scanner.nextInt();
            if (number1 > 0) {
                break;
            } else {
                System.out.println("Number of element must be geater than 0");
            }
        } while (true);
        array1 = new int[number1];
        for (int i = 0; i < array1.length; i++) {
            System.out.print("Enter value of element " + (i + 1) + " of your array: ");
            array1[i] = scanner.nextInt();
        }
        //display array1
        System.out.print("Your array 1 is: ");
        displayArray(array1);
        //Enter Array2
        do {
            System.out.print("Enter the number of element of your Array2: ");
            number2 = scanner.nextInt();
            if (number2 > 0) {
                break;
            } else {
                System.out.println("Number of element must be geater than 0");
            }
        } while (true);
        array2 = new int[number2];
        for (int i = 0; i < array2.length; i++) {
            System.out.print("Enter value of element " + (i + 1) + " of your array: ");
            array2[i] = scanner.nextInt();
        }
        //display array2
        System.out.print("Your array 2 is: ");
        displayArray(array2);
        //combine Array 1 and Array 2
        number = array1.length + array2.length;
        combineArray = new int[number];
        for (int i = 0; i < array1.length; i++) {
            combineArray[i] = array1[i];
        }
        for (int i = array1.length; i < combineArray.length; i++) {
            combineArray[i] = array2[i - array1.length];
        }
        System.out.print("Combine Array is: ");
        displayArray(combineArray);
    }

    public static void displayArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
