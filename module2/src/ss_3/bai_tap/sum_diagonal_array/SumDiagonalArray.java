package ss_3.bai_tap.sum_diagonal_array;

import java.util.Scanner;

public class SumDiagonalArray {
    public static void main(String[] args) {
        int row, col;
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
            if (col > 0 && col == row) {
                break;
            } else {
                System.out.println("number of colum must be greater than 0 and equal the row");
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
        //calculate sum of element at diagonal of array
        float sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    sum = sum + array[i][j];
                }
            }
        }
        System.out.println("Sum of element at diagonal of array is: " + sum);
    }
}
