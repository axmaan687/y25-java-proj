package com.armaan;
import java.util.Arrays;

public class AnagramString {
    public static void main(String[] args) {
        
        String str1 = "listen";
        String str2 = "silent";

        // Convert to lowercase to ignore case differences
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Convert strings to character arrays
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Check if both sorted arrays are equal
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are NOT anagrams.");
        }
    }
}