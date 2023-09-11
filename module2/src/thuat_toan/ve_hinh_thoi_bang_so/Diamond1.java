package thuat_toan.ve_hinh_thoi_bang_so;

import java.util.Arrays;
import java.util.Scanner;

public class Diamond1 {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={3,4,5};
        swapArr(arr1, arr2);
        System.out.println(Arrays.toString(arr1));

    }

    public static void swapArr(int [] arr1, int[] arr2){
        int  tempt;
        tempt = arr1[0];
        arr1[0]=arr2[0];
        arr2[0] =tempt;
    }
}
