package ss_3.bai_tap.sum_element_at_colum;

import java.util.Scanner;

public class SumColum {
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
        //Calculate sum at a colum:
        System.out.print("Enter the colum (from 0 to (col-1)) that you want to calculate sum: ");
        int sumCol = scanner.nextInt();
        float sum = 0;
        if (sumCol >= 0 && sumCol < col) {
            for (int i = 0; i < array.length; i++) {
                sum = sum + array[i][sumCol];
            }
            System.out.println("Sum of element at colum " + sumCol + " is: " + sum);
        } else {
            System.out.println("Colum " + sumCol + " of array is not exist");
        }
    }
}
