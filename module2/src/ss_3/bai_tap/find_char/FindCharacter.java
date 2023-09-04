package ss_3.bai_tap.find_char;

import java.util.Scanner;

public class FindCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your string: ");
        String str = scanner.nextLine();
        System.out.println("Your string is: "+ str);
        System.out.print("Please enter a char that you want to find in the string: ");
        char findChar = scanner.next().charAt(0);
        int count = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)==findChar){
                count++;
            }
        }
        System.out.println("There are(is) "+count+" character "+findChar+" in this string: "+str);
    }
}
