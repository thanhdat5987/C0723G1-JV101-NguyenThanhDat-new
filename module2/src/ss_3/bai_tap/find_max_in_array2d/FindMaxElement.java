package ss_3.bai_tap.find_max_in_array2d;

import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        int row;
        int col;
        float[][] array;
        Scanner scanner = new Scanner(System.in);
        // enter number of array 's row:
        do {
            System.out.print("Enter number row of 2d array: ");
            row = scanner.nextInt();
            if (row > 0) {
                break;
            } else {
                System.out.println("number of row must be greater than 0");
            }
        } while (true);
        // enter number of array 's colum:
        do {
            System.out.print("Enter number colum of 2d array: ");
            col = scanner.nextInt();
            if (col > 0) {
                break;
            } else {
                System.out.println("number of colum must be greater than 0");
            }
        } while (true);
        array = new float[row][col];
        //enter element value of 2d array:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("Please enter value element [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextFloat();
            }
        }
        //display 2d array:
        System.out.println("Your array is: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
        //find max element
        float max = array[0][0];
        int rowIndex = -1;
        int colIndex = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] >= max) {
                    max = array[i][j];
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        System.out.println("Max Element of 2d Array is: " + max + " at index [" + rowIndex + "][" + colIndex + "]");
    }
}
