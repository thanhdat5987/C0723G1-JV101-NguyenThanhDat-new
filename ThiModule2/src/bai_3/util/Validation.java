package bai_3.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String BILL_REGEX ="^MHD-[0-9]{4}";
    public static boolean checkRegexBillId(String billId){
        Pattern pattern = Pattern.compile(BILL_REGEX);
        Matcher matcher = pattern.matcher(billId);
        return matcher.matches();
    }
}
