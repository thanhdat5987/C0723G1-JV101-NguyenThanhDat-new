package thuat_toan_25Oct;

import java.util.ArrayList;
import java.util.List;

public class ThuatToan {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4}};
        solution(arr);
    }
   public static int[] solution(int[][] arr) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                boolean check = true;
                for (int k = 2; i <= Math.sqrt(j); i++) {
                    if (j % k == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    a.add(j);
                }
            }
        }
        Integer temp;
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i) > a.get(j)) {
                    temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }
        }
        int[] b = new int[a.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = a.get(i);
        }
        return b;
    }
}
