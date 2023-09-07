package ss_3.bai_tap.del_element;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DelElement {
    public static void main(String[] args) {
        int number;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter number of element of Array: ");
            number = scanner.nextInt();
            if (number > 0) {
                break;
            } else {
                System.out.println("Number of element must be greater than 0");
            }
        } while (true);
        array = new int[number];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter the value of the element " + (i + 1) + " of array: ");
            array[i] = scanner.nextInt();
        }
        //display array:
        System.out.print("Your array is: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Enter the element that you want to delete: ");
        int delElement = scanner.nextInt();
        boolean check = false;
        int indexDel;
        String stringDelIndex = "";//Create a string to add index of element that you want to delete (maybe many elements have same value)
        // Add index of elements that will be deleted.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == delElement) {
                stringDelIndex = stringDelIndex + i + " ";
            }
        }
        //Delete element as request.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == delElement) {
                check = true;
                indexDel = i;
                int temp;
                for (int j = indexDel; j < array.length - 1; j++) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                if (array[array.length - 1] != 0) {
                    array[array.length - 1] = 0;
                    i--;
                }
            }
        }
        //display array after delete delElement
        if (check) {
            System.out.println("Element " + delElement + " at index " + stringDelIndex);
            System.out.print("Your array after delete element with value is " + delElement + " is: ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        } else {
            System.out.println("Sorry, " + delElement + " is not at your array!");
        }
    }
}
