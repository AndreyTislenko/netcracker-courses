package com.netcracker.firstAndSecondTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String password = "qwerty";
    private static final String loginRegex = "^[\\d\\w]+$"; //any number and word character (even _ )
    private static final String loginPage = "login.html";
    private static final String wrongPasswordPage = "wrongPasswordPage.html";
    private static final String incorrectLoginPage = "incorrectLoginPage.html";

    public static boolean validatePassword(String password) {
        return password.equals(Validation.password);
    }
    public static boolean validateLogin(String login){
        Pattern pattern = Pattern.compile(loginRegex);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }

    public static String getLoginPage() {
        return loginPage;
    }
    public static String getWrongPasswordPage() {
        return wrongPasswordPage;
    }
    public static String getIncorrectLoginPage() {
        return incorrectLoginPage;
    }
}
