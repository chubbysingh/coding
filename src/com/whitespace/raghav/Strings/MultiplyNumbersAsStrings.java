package com.whitespace.raghav.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 9/22/15.
 */
public class MultiplyNumbersAsStrings {

    private static String multiply(String s1, String s2) {
        if (s1 == null || s2 == null)
            return null;
        if (s1.length() == 0 || s2.length() == 0)
            return "0";

        validate(s1);
        validate(s2);

        int length1 = s1.length(), length2 = s2.length(), length = Math.max(length1, length2);
        int[] arr1 = toIntArray(s1, length1, length);
        int[] arr2 = toIntArray(s2, length2, length);

        return product(arr1, arr2);

    }

    // Computes the product
    private static String product(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<Integer>();
        int carry = 0;
        int multiply = 1;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (i > 0) {
                    multiply = 10 * i;
                }
                int product = multiply * (arr1[j] * arr2[i]) + carry;
                result.add(product % 10);
                carry = product / 10;
            }
        }

        return toString(result);
    }

    private static String toString(List<Integer> result) {
        StringBuilder sb = new StringBuilder(result.size());
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    // Converts a string into int array in reverse
    // e.g. ("1234", 4, 6) ----> {4, 3, 2, 1, 0, 0}
    private static int[] toIntArray(String str, int length1, int size) {
        int[] arr = new int[size];
        int counter = str.length() - 1;
        for (int i = 0; i < size; i++) {
            if (i < length1) {
                arr[i] = Integer.parseInt(String.valueOf(str.charAt(counter)));
                counter--;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    //Validates if input is correct
    private static void validate(String s1) {
        for (int i = 0; i < s1.length(); i++) {
            if (!Character.isDigit(s1.charAt(i)))
                throw new IllegalArgumentException("Input is invalid");
        }
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "2";
        System.out.println("Multiplication ---> " + multiply(s1, s2));
    }
}
