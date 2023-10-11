package thuat_toan.ve_hinh_thoi_bang_so;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class thuattoan20Sep {
    public static void main(String[] args) {
       String result= solution("NguyenThanhDat");
        System.out.println(result);

    }

   static String solution(String s) {

        String[] array = s.split("");
        String string = array[0].toLowerCase();
        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(array[i].toLowerCase())) {
                string += array[i];
            } else {
                string += " " + array[i].toLowerCase();
            }
        }
        return string;
    }
}

