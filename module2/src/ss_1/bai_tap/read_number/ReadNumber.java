package ss_1.bai_tap.read_number;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        System.out.println("---Read number programming---");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number greater than 0 and less than 1000: ");
        int number = sc.nextInt();
        if (number >= 1000 || number < 0) {
            System.out.println("Out of ability");
            return;
        }
        if (number < 10) {
            System.out.println(number + " read as " + readUnitDigit(number));
        } else if (number < 20) {
            int unitDigit = number % 10;
            System.out.println(number + " read as " + readTensLessThan20(unitDigit));
        } else if (number < 100) {
            int unitDigit = number % 10;
            int tensDigit = number / 10;
            if (unitDigit == 0) {
                System.out.println(number + " read as " + readTensFrom20(tensDigit));
            } else {
                System.out.println(number + " read as " + readTensFrom20(tensDigit) + " " + readUnitDigit(unitDigit));
            }
        } else {
            int hundredDigit = number / 100;
            int tens = number % 100;
            int unitDigit = tens % 10;
            int tensDigit = tens / 10;
            String readUnit = readUnitDigit(unitDigit);
            String readTens;
            if (tensDigit == 1) {
                readTens = readTensLessThan20(unitDigit);
            } else {
                readTens = readTensFrom20(tensDigit);
            }
            String readHundred = readUnitDigit(hundredDigit);
            if (tensDigit == 0 && unitDigit == 0) {
                System.out.println(number + " read as " + readHundred + " hundred");
            } else if (tensDigit == 1) {
                System.out.println(number + " read as " + readHundred + " hundred" + " and " + readTens);
            } else if (tensDigit == 0) {
                System.out.println(number + " read as " + readHundred + " hundred" + " and " + readUnit);
            } else {
                System.out.println(number + " read as " + readHundred + " hundred" + " and " + readTens + " " + readUnit);
            }
        }
    }

    public static String readUnitDigit(int unitDigit) {
        String readUnit = "";
        switch (unitDigit) {
            case 0:
                readUnit = "Zero";
                break;
            case 1:
                readUnit = "One";
                break;
            case 2:
                readUnit = "Two";
                break;
            case 3:
                readUnit = "Three";
                break;
            case 4:
                readUnit = "Four";
                break;
            case 5:
                readUnit = "Five";
                break;
            case 6:
                readUnit = "Six";
                break;
            case 7:
                readUnit = "Seven";
                break;
            case 8:
                readUnit = "Eight";
                break;
            case 9:
                readUnit = "Nine";
                break;
        }
        return readUnit;
    }

    public static String readTensLessThan20(int unitDigit) {
        String readTens = "";
        switch (unitDigit) {
            case 0:
                readTens = "Ten";
                break;
            case 1:
                readTens = "Eleven";
                break;
            case 2:
                readTens = "Twelve";
                break;
            case 3:
                readTens = "Thirteen";
                break;
            case 4:
                readTens = "Fourteen";
                break;
            case 5:
                readTens = "Fifteen";
                break;
            case 6:
                readTens = "Sixteen";
                break;
            case 7:
                readTens = "Seventeen";
                break;
            case 8:
                readTens = "Eighteen";
                break;
            case 9:
                readTens = "Nineteen";
                break;
        }
        return readTens;
    }

    public static String readTensFrom20(int tensDigit) {
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
        return readTens;
    }
}