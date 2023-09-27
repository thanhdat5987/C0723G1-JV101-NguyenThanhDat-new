package ss_19.bai_tap.validate_phone_number;

import java.util.Scanner;

public class PhoneNumberExampleTest {
    public static void main(String[] args) {
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
        System.out.println("Enter phone Number: ");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();
        System.out.println(phoneNumberExample.validate(phoneNumber));
    }
}
