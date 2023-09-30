package ss_14.thuc_hanh.test;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, -1, -5, -6};
        System.out.println(Arrays.toString(array));
//        bubbleSort(array);
//        sortSelection(array);
        selectionSort1(array);
        System.out.println(Arrays.toString(array));

    }

//    private static void sortInsertion(int[] array) {
//        int x;
//        int j;
//        for (int i = 1; i < array.length; i++) {
//            x = array[i];
//            j = i;
//            while (j > 0 && x < array[j - 1]) {
//                array[j] = array[j - 1];
//                j--;
//            }
//            array[j] = x;
//        }
//    }

//    private static void sortSelection(int[] array) {
//        int min;
//        int temp;
//        for (int i = 0; i < array.length - 1; i++) {
//            min = i;
//
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] <= array[min]) {
//                    min = j;
//                }
//                if (min != i) {
//                    temp = array[min];
//                    array[min] = array[i];
//                    array[i] = temp;
//                }
//            }
//        }
//    }

//    private static void bubbleSort(int[] array) {
//        int temp;
//        for (int i = 0; i < array.length - 1; i++) {
//            System.out.println("-----" + i);
//            for (int j = 1; j < array.length - i; j++) {
//                if (array[j] < array[j - 1]) {
//                    temp = array[j - 1];
//                    array[j - 1] = array[j];
//                    array[j] = temp;
//                    System.out.println(Arrays.toString(array));
//                }
//            }
//
//        }
//    }
    public static void bubbleSort1(int []array){
        int temp;
        for (int i=0; i<array.length-1; i++){
            for(int j=1; j<array.length-i;j++){
                if(array[j]>array[j-1]){
                    temp= array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
    public static void selectionSort1(int[]array){
        int minIndex;
        int temp;
        for(int i=0; i<array.length-1; i++){
            minIndex=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                temp=array[minIndex];
                array[minIndex]= array[i];
                array[i]=temp;
            }
        }
    }
    public static void sortInsertion1(int []array){
        int x;
        int j;
        for(int i=1; i<array.length; i++){
            x =array[i];
            j=i;
            while (j>0&& array[j-1]>x){
                array[j]=array[j-1];
                j--;
            }
            array[j]=x;
        }
    }
}
