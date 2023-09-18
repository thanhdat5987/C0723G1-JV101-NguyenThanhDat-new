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
        newList.add(3, 10);
        System.out.println("size: " + newList.size());
        Object[] newlist1 = (Object[]) newList.clone();
        System.out.println("clone list:" + Arrays.toString(newlist1));
        System.out.println(newList.contains(11));
        System.out.println(newList.contains(0));
        System.out.println(newList.indexOf(3));
        System.out.println(newList.indexOf(8));
        newList.clear();
        newList.add(11);
        newList.add(12);
        newList.add(13);
        System.out.println(newList.get(1));
        newList.remove(1);
        System.out.println(newList.get(1));
        System.out.println(newList.size());
    }
}
