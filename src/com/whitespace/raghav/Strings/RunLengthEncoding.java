package com.whitespace.raghav.Strings;

/**
 * Created by rbhatnagar2 on 9/8/15.
 */
public class RunLengthEncoding {

    private static String encoding(String input) {
        if (input == null || input == "")
            return "";

        StringBuilder res = new StringBuilder();
        int count = 1;
        res.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                res.append(count);
                res.append(input.charAt(i));
                count = 1;
            }
        }
        return res.append(count).toString();
    }

    public static void main(String[] args) {
        String input = "wwwwaaadexxxxxx";
        System.out.println(encoding(input));
    }
}
