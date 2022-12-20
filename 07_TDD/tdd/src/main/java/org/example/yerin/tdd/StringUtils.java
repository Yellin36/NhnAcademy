package org.example.yerin.tdd;

public class StringUtils {
    public static boolean isPalindrome(String candidate) {
        return new StringBuilder(candidate).reverse().toString().equals(candidate);
    }
}
