package com.armaan;
public class ArmstrongNumber1to1000 {
    public static void main(String[] args) {
        
        System.out.println("Armstrong numbers between 1 and 1000 are:");

        for (int num = 1; num <= 1000; num++) {
            int sum = 0, temp = num;
            int digits = String.valueOf(num).length();  // number of digits

            while (temp > 0) {
                int digit = temp % 10;
                sum += Math.pow(digit, digits);  // digit^digits
                temp /= 10;
            }

            if (sum == num) {
                System.out.println(num);
            }
        }
    }
}
