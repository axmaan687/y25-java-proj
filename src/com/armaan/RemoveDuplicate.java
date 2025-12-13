package com.armaan;

public class RemoveDuplicate {
    public static void main(String[] args) {

        String str = "programming";
        String result = "";

        // Loop through each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Add character only if it's not already in result
            if (result.indexOf(ch) == -1) {
                result += ch;
            }
        }

        System.out.println("Original String : " + str);
        System.out.println("After Removing Duplicates : " + result);
    }
}