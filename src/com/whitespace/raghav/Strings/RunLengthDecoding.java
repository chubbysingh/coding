package com.whitespace.raghav.Strings;

/**
 * Created by rbhatnagar2 on 9/8/15.
 */
public class RunLengthDecoding {
    private static String decoding(String input) {
        if (input == null || input == "")
            return input;

        StringBuilder sb = new StringBuilder();
        Character pre = null;
        for (int i=0; i< input.length(); i++) {

            if (i==0) {
                sb.append(input.charAt(i));
                pre = input.charAt(i);
            }

            else if (Character.isDigit(input.charAt(i))){
                int occurrence = 0;
                StringBuilder curr = new StringBuilder();
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    curr.append(input.charAt(i));
                    i++;
                }
                i--;
                occurrence = Integer.parseInt(curr.toString());
                while (occurrence > 1) {
                    sb.append(pre);
                    occurrence--;
                }
            } else {
                sb.append(input.charAt(i));
                pre = input.charAt(i);
            }


        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "a4b16z9";
        System.out.println(decoding(input).equals("aaaabbbbbbbbbbbbbbbbzzzzzzzzz"));

    }
}
