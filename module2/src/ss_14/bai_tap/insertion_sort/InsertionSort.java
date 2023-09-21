package ss_14.bai_tap.insertion_sort;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.print("Please enter size of your list: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        if(size<=0){
            System.out.println("size must be >0");
            return;
        }
        int[] numberList = new int[size];
        for (int i = 0; i < numberList.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numberList[i] = scanner.nextInt();
        }
        displayList(numberList);
        sortByInsertion(numberList);
    }

    private static void displayList(int[] list) {
        System.out.print("Your list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    private static void sortByInsertion(int[] list) {
        int j;
        int x;
        System.out.println("--Start------------");
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            j = i;
            System.out.println("With i= " + i + ", x = list[" + i + "] = " + list[i]);
            System.out.println("Check condition j =" + j + ">0?" + " & x<list[j-1]");
            while (j > 0 && x < list[j - 1]) {
                System.out.println("Assign list[" + j + "]=list[" + (j - 1) + "]");
                list[j] = list[j - 1];
                displayList(list);
                j--;
                System.out.println("j= " + j);
                System.out.println("Check condition j =" + j + ">0?" + " & x<list[j-1]");
            }
            System.out.println("Finish While-loop");
            System.out.println("Assign list[" + j + "] = x = " + x);
            list[j] = x;
            displayList(list);
            System.out.println("Finish with i= " + i);
            System.out.println("------------------");
        }
    }
}
