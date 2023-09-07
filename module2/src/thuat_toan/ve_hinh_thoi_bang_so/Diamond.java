package thuat_toan.ve_hinh_thoi_bang_so;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        for (int i = 1; i<=5; i++){
            for (int j =1; j<=5-i;j++){
                System.out.print(" ");
            }
            System.out.print(i);
            for (int j=1; j<= 2*i -1; j++){
                System.out.print(" ");
            }
            System.out.print(i + "\n");
        }
        for (int i = 4; i>=1; i--){
            for (int j =1; j<=5-i;j++){
                System.out.print(" ");
            }
            System.out.print(i);
            for (int j=1; j<= 2*i -1; j++){
                System.out.print(" ");
            }
            System.out.print(i + "\n");
        }
    }
}
