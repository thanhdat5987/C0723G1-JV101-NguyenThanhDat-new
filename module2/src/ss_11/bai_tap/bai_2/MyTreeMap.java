package ss_11.bai_tap.bai_2;

import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        String myString = "baddaabdbbcddd";
        getWord(myString);
    }

    public static void getWord(String myString) {
        TreeMap<String, Integer> myTreeMap = new TreeMap<>();
        for (int i = 0; i < myString.length(); i++) {
            String upperLetter = String.valueOf(myString.charAt(i)).toUpperCase();
            if (!myTreeMap.containsKey(upperLetter)) {
                myTreeMap.put(upperLetter, 1);
            } else {
                myTreeMap.put(upperLetter, myTreeMap.get(upperLetter) + 1);
            }
        }
        System.out.println(myTreeMap);
    }

}
