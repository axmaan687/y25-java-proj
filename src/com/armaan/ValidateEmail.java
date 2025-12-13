package com.armaan;

import java.util.regex.*;

public class ValidateEmail {
    public static void main(String[] args) {

        String email = "example@gmail.com";

        // Simple email regex pattern
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the email
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("Valid Email Address");
        } else {
            System.out.println("Invalid Email Address");
        }
    }
}
