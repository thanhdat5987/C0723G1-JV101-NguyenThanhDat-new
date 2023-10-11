package de_mo.thuc_hanh_mvc1.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String CAR_ID_REGEX ="^C-[0-9]{4}";
    public static boolean validateCarId(String carId){
       Pattern pattern = Pattern.compile(CAR_ID_REGEX);
       Matcher matcher = pattern.matcher(carId);
       return matcher.matches();
    }

}
