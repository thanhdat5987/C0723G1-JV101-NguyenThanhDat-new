package ss_13.bai_tap.consecutive_string;

import java.util.Scanner;

public class ConsecutiveString {
    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();
        if (myString.length() > 1) {
            System.out.println(searchMaxConsecutiveString(myString));
        } else {
            System.out.println("Length of string must be >1");
        }
    }

    static String searchMaxConsecutiveString(String string) {
        String maxLengthList = "";
        String tempList;
        for (int i = 0; i < string.length(); i++) {
            tempList = "";
            tempList += string.charAt(i);
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > tempList.charAt(tempList.length() - 1)) {
                    tempList += string.charAt(j);
                } else {
                    break;
                }
            }
            if (tempList.length() > maxLengthList.length()) {
                maxLengthList = "";
                maxLengthList += tempList;
            }
        }
        return maxLengthList;
    }
}
