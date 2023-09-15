package ss_10.bai_tap.list;

import java.util.ArrayList;
import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> newList = new MyList<>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        newList.add(5);
        System.out.println(newList.get(0));
        System.out.println(newList.size());
        newList.remove(0);
        System.out.println(newList.get(0));
        System.out.println(newList.size());
        Object[] newlist1 = (Object[]) newList.clone();
        System.out.println(Arrays.toString(newlist1));
        boolean check =newList.add(9);
        System.out.println(check);
        System.out.println(newList);
        System.out.println(newList.size());
    }
}
