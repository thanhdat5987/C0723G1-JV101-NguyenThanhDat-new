package ss_13.bai_tap.binary_search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] myArray = {1, 3, 2, 4, 5, 9, 7, 8, 6, 10, 12, 15, 17, 19};
        sortArray(myArray);
        System.out.println(Arrays.toString(myArray));
        System.out.println(searchByBinary(myArray, 8, 0, myArray.length - 1));
    }

    private static void sortArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] >= array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static int searchByBinary(int[] array, int number, int left, int right) {
        while (right >= left) {
            int mid = (left + right) / 2;
            if (array[mid] == number) {
                return mid;
            } else if (number > array[mid]) {
                return searchByBinary(array, number, left + 1, right);
            } else {
                return searchByBinary(array, number, left, mid - 1);
            }
        }
        return -1;
    }
}
