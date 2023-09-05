package ss_1.bai_tap.read_number;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        System.out.println("---Read number programming---");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number greater than 0 and less than 1000: ");
        int number = sc.nextInt();
        if (number >= 1000 || number <= 0) {
            System.out.println("Out of ability");
            return;
        }
        if (number < 10) {
            switch (number) {
                case 1:
                    System.out.println(number + " reads as One");
                    break;
                case 2:
                    System.out.println(number + " reads as Two");
                    break;
                case 3:
                    System.out.println(number + " reads as Three");
                    break;
                case 4:
                    System.out.println(number + " reads as Four");
                    break;
                case 5:
                    System.out.println(number + " reads as Five");
                    break;
                case 6:
                    System.out.println(number + " reads as Six");
                    break;
                case 7:
                    System.out.println(number + " reads as Seven");
                    break;
                case 8:
                    System.out.println(number + " reads as Eight");
                    break;
                case 9:
                    System.out.println(number + " reads as Nine");
                    break;
            }
        } else if (number < 20) {
            int unitDigit = number % 10;
            switch (unitDigit) {
                case 0:
                    System.out.println(number + " read as Ten");
                    break;
                case 1:
                    System.out.println(number + " read as Eleven");
                    break;
                case 2:
                    System.out.println(number + " read as Twelve");
                    break;
                case 3:
                    System.out.println(number + " read as Thirteen");
                    break;
                case 4:
                    System.out.println(number + " read as Fourteen");
                    break;
                case 5:
                    System.out.println(number + " read as Fifteen");
                    break;
                case 6:
                    System.out.println(number + " read as Sixteen");
                    break;
                case 7:
                    System.out.println(number + " read as Seventeen");
                    break;
                case 8:
                    System.out.println(number + " read as Eighteen");
                    break;
                case 9:
                    System.out.println(number + " read as Nineteen");
                    break;
            }
        } else if (number < 100) {
            int unitDigit = number % 10;
            int tensDigit = number / 10;
            String readUnit = "";
            String readTens = "";
            switch (tensDigit) {
                case 2:
                    readTens = "Twenty";
                    break;
                case 3:
                    readTens = "Thirty";
                    break;
                case 4:
                    readTens = "Forty";
                    break;
                case 5:
                    readTens = "Fifty";
                    break;
                case 6:
                    readTens = "Sixty";
                    break;
                case 7:
                    readTens = "Seventy";
                    break;
                case 8:
                    readTens = "Eighty";
                    break;
                case 9:
                    readTens = "Ninety";
                    break;
            }
            switch (unitDigit) {
                case 0:
                    readUnit = "";
                    break;
                case 1:
                    readUnit = "one";
                    break;
                case 2:
                    readUnit = "two";
                    break;
                case 3:
                    readUnit = "three";
                    break;
                case 4:
                    readUnit = "four";
                    break;
                case 5:
                    readUnit = "five";
                    break;
                case 6:
                    readUnit = "six";
                    break;
                case 7:
                    readUnit = "seven";
                    break;
                case 8:
                    readUnit = "eight";
                    break;
                case 9:
                    readUnit = "nine";
                    break;

            }
            System.out.println(number + " read as " + readTens + " " + readUnit);
        } else {
            int hundredDigit = number / 100;
            int tens = number % 100;
            int unitDigit = tens % 10;
            int tensDigit = tens / 10;
            String readUnit = "";
            String readTens = "";
            String readHundred = "";
            String readTens1 = "";
            switch (tensDigit) {
                case 1:
                    switch (unitDigit) {
                        case 0:
                            readTens1 = "ten";
                            break;
                        case 1:
                            readTens1 = "eleven";
                            break;
                        case 2:
                            readTens1 = "twelve";
                            break;
                        case 3:
                            readTens1 = "thirteen";
                            break;
                        case 4:
                            readTens1 = "fourteen";
                            break;
                        case 5:
                            readTens1 = "fifteen";
                            break;
                        case 6:
                            readTens1 = "sixteen";
                            break;
                        case 7:
                            readTens1 = "seventeen";
                            break;
                        case 8:
                            readTens1 = "eighteen";
                            break;
                        case 9:
                            readTens1 = "nineteen";
                            break;
                    }

                case 2:
                    readTens = "Twenty";
                    break;
                case 3:
                    readTens = "Thirty";
                    break;
                case 4:
                    readTens = "Forty";
                    break;
                case 5:
                    readTens = "Fifty";
                    break;
                case 6:
                    readTens = "Sixty";
                    break;
                case 7:
                    readTens = "Seventy";
                    break;
                case 8:
                    readTens = "Eighty";
                    break;
                case 9:
                    readTens = "Ninety";
                    break;
            }
            switch (unitDigit) {
                case 0:
                    readUnit = "";
                    break;
                case 1:
                    readUnit = "one";
                    break;
                case 2:
                    readUnit = "two";
                    break;
                case 3:
                    readUnit = "three";
                    break;
                case 4:
                    readUnit = "four";
                    break;
                case 5:
                    readUnit = "five";
                    break;
                case 6:
                    readUnit = "six";
                    break;
                case 7:
                    readUnit = "seven";
                    break;
                case 8:
                    readUnit = "eight";
                    break;
                case 9:
                    readUnit = "nine";
                    break;

            }
            switch (hundredDigit) {
                case 1:
                    readHundred = "One Hundred";
                    break;
                case 2:
                    readHundred = "Two Hundred";
                    break;
                case 3:
                    readHundred = "Three Hundred";
                    break;
                case 4:
                    readHundred = "Four Hundred";
                    break;
                case 5:
                    readHundred = "Five Hundred";
                    break;
                case 6:
                    readHundred = "Six Hundred";
                    break;
                case 7:
                    readHundred = "Seven Hundred";
                    break;
                case 8:
                    readHundred = "Eight Hundred";
                    break;
                case 9:
                    readHundred = "Nine Hundred";
                    break;
            }
            if (tensDigit == 0 && unitDigit == 0) {
                System.out.println(number + " read as " + readHundred);
            } else if (tensDigit == 1) {
                System.out.println(number + " read as " + readHundred + " and " + readTens1);
            } else if (tensDigit == 0) {
                System.out.println(number + " read as " + readHundred + " and " + readUnit);
            } else {
                System.out.println(number + " read as " + readHundred + " and " + readTens + " " + readUnit);
            }
        }
    }
}
