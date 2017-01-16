package com.whitespace.raghav.Strings;

/**
 * Created by rbhatnagar2 on 9/8/15.
 */
public class Reverse {
    private static String reverse(String input) {
        if (input == null)
            return null;

        if (input.length() == 0)
            return input;

        return input.substring(1) + input.charAt(0);
    }

    public static void main(String[] args) {
        String input = "Hello";
        System.out.println(reverse(input));
    }
}
