package ss_3.thuc_hanh.reverse_array;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter array size (0<size<20): ");
            size = scanner.nextInt();
            if (size < 20 && size > 0) {
                break;
            } else {
                System.out.println("Array size must be >0 and <20");
            }
        } while (true);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + (i + 1) + " of array: ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Elements of arrray: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        //Reverse array element:
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        //Display array element after reverse:
        System.out.println();
        System.out.print("Array elements after reverse: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
