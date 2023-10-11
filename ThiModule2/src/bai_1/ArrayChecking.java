package bai_1;

public class ArrayChecking {
    public static void main(String[] args) {
        int[] myArray = {0, 2, 4, 6, 8, 10};
        System.out.println(checkArray(myArray));
    }

    public static boolean checkArray(int[] arr) {
        boolean check = false;
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i] - arr[i - 1]) == (arr[i + 1] - arr[i])) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }
}

