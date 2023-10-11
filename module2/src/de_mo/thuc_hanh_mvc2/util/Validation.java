package de_mo.thuc_hanh_mvc2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String BOOK_ID_REGEX ="^SA-[0-9]{4}";
    public static boolean validateBookId(String bookId){
        Pattern pattern =Pattern.compile(BOOK_ID_REGEX);
        Matcher matcher= pattern.matcher(bookId);
        return matcher.matches();
    }
}
