package case_study.furama.util;

import case_study.furama.model.Employee;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static Scanner scanner = new Scanner(System.in);
    public static final String EMPLOYEE_ID_REGEX = "^NV-[0-9]{4}$";
    public static final String CUSTOMER_ID_REGEX = "^KH-[0-9]{4}$";

    public static final String PERSON_NAME_REGEX = "^([A-Z][a-z]+)((\\s{1}[A-Z][a-z]*)+)$";
    public static final String PERSON_CITIZEN_ID_REGEX = "^([0-9]{9}|[0-9]{12})$";
    public static final String PHONE_NUMBER_REGEX = "^0[0-9]{9}$";
    public static final String DATE_OF_BIRTH_REGEX = "^(((0+[1-9]|[12][0-9]|3[0])[/]((0+[4|6|9])|1[1])[/]\\d{4}))|(((0+[1-9]|[12][0-9]|[3][0|1])[/]((0+[1|3|5|7|8])|1+[0|2])[/]\\d{4}))|(((0+[1-9]|[12][0-9]))[/]02)[/]\\d{4}$";
    public static boolean validateEmployeeId(String regex) {
        Pattern pattern = Pattern.compile(EMPLOYEE_ID_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateCustomerId(String regex) {
        Pattern pattern = Pattern.compile(CUSTOMER_ID_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validatePersonName(String regex) {
        Pattern pattern = Pattern.compile(PERSON_NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateCitizenId(String regex) {
        Pattern pattern = Pattern.compile(PERSON_CITIZEN_ID_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String regex) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateDateOfBirth(String regex) {
        Pattern pattern = Pattern.compile(DATE_OF_BIRTH_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static String enterEmployeeId() {
        do {
            System.out.println("Input Employee ID with format NV-xxxx (x is number)");
            String employeeId = scanner.nextLine();
            if (validateEmployeeId(employeeId)) {
                return employeeId;
            } else {
                System.out.println("Please following format NV-xxxx");
            }
        } while (true);
    }

    public static String enterCustomerId() {
        String customerId;
        do {
            System.out.println("Input Customer ID with format KH-xxxx (x is number)");
            customerId = scanner.nextLine();
            if (validateCustomerId(customerId)) {
                return customerId;
            } else {
                System.out.println("Please following format KH-xxxx");
            }
        } while (true);
    }

    public static String enterPersonName() {
        String newName;
        do {
            System.out.println("Enter name of Employee with format: Starting each word with a capital letter :");
            newName = scanner.nextLine();
            if (Validation.validatePersonName(newName)) {
                return newName;
            } else {
                System.out.println("Please following format: Starting each word with a capital letter");
            }
        } while (true);
    }

    public static String enterCitizenId() {
        String citizenId;
        do {
            System.out.println("Enter citizen ID with 9 or 12 numbers");
            citizenId = scanner.nextLine();
            if (Validation.validateCitizenId(citizenId)) {
                return citizenId;
            } else {
                System.out.println("Please following format: 9 or 12 number");
            }
        } while (true);
    }

    public static String enterPhoneNumber() {
        String phoneNumber;
        do {
            System.out.println("Enter phone number, begin with 0 and have 10 numbers");
            phoneNumber = scanner.nextLine();
            if (Validation.validatePhoneNumber(phoneNumber)) {
                return phoneNumber;
            } else {
                System.out.println("Please following format: begin with 0 and have 10 numbers");
            }
        } while (true);
    }

    public static String enterDateOfBirth() {
        String dateOfBirth;
        do {
            System.out.println("Enter date of birth, with format dd/mm/yyyy");
            dateOfBirth = scanner.nextLine();
            if (validateDateOfBirth(dateOfBirth)) {
                if(checkLeapBirthYear(dateOfBirth)){
                    return dateOfBirth;
                }else {
                    System.out.println("Please check year of birth if it is leap year or not");
                }
            } else {
                System.out.println("Please following format dd/mm/yyyy");
            }
        } while (true);
    }

    public static boolean checkLeapBirthYear(String dateOfBirth) {
        String[] spittedDateOfBirth = dateOfBirth.split("/");
        if (checkLeapYear(Integer.parseInt(spittedDateOfBirth[2]))) {
            if (Integer.parseInt(spittedDateOfBirth[1]) == 2) {
                if (Integer.parseInt(spittedDateOfBirth[0]) == 29) {
                    return true;
                }else {
                    return false;
                }
            }
        } else {
            if (Integer.parseInt(spittedDateOfBirth[1]) == 2) {
                if (Integer.parseInt(spittedDateOfBirth[0]) == 28) {
                    return true;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                return true;
            } else {
                if (year % 400 != 0) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
    }
}
