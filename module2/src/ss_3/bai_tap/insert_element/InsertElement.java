package ss_3.bai_tap.insert_element;

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        int number;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter the number of element of your Array: ");
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
        //display array
        System.out.print("Your array is: ");
        displayArray(array);
        System.out.print("Enter a value of element that you want to insert to your array: ");
        int insertElement = scanner.nextInt();
        System.out.print("Enter the index of this element: ");
        int indexInsert = scanner.nextInt();
        if (indexInsert < array.length && indexInsert > 0) {
            int temp;
            array[array.length - 1] = array[array.length - 2];
            for (int i = array.length - 2; i > indexInsert; i--) {
                temp = array[i];
                array[i - 1] = array[i];
                array[i] = temp;
            }
            array[indexInsert] = insertElement;
            System.out.print("Your array after insert " + insertElement + " at index " + indexInsert + " is: ");
            displayArray(array);
        } else {
            System.out.println("Your array doesn't have index " + indexInsert);
        }
    }

    public static void displayArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
