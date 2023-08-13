package com.ecamsolution.serviceImpl.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterValidation {

    private static final String PHONE_NUMBER_REGEX = "^[0-9]{9,10}$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";


    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


//    public static  boolean matchingPassword(String pass, String confirm){
//        boolean password = validatePassword(pass);
//        if(pass.equals(confirm)){
//            return password;
//        }
//        return false;
//    }
//
//    public  static boolean validatePasswordRegister(String pass, String verify){
//        boolean password = validatePassword(pass);
//        boolean verifyPass = validatePassword(verify);
//        if(password && verifyPass){
//            return true;
//        }
//        return false;
//    }

    public  static boolean passMatch(String pass, String verify){
        if(pass.equals(verify)){
            return validatePassword(pass);
        }
        return false;
    }




    /*
        the `PASSWORD_REGEX` pattern checks for the following criteria:
          - `(?=.*[0-9])` - At least one digit.
          - `(?=.*[a-z])` - At least one lowercase letter.
          - `(?=.*[A-Z])` - At least one uppercase letter.
          - `(?=.*[@#$%^&+=])` - At least one special character from the provided set.
          - `(?=\\S+$)` - No whitespace allowed.
          - `.{8,}` - At least 8 characters in total.
     */



}
