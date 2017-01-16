package com.whitespace.raghav.Strings;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 9/8/15.
 */
public class RemoveDups {

    private static String removeDups(String input) {
        if (input == null || input == "")
            return null;

        StringBuilder s = new StringBuilder(input.length());
        Set<Character> set = new LinkedHashSet<Character>();

        for (char ch : input.toCharArray()) {
            set.add(ch);
        }

        for (Character c : set) {
            s.append(c);
        }
        return s.toString();
    }

    /**
     * @param input
     * @return
     */
    private static String removeDups2(String input) {
       if (input == null || input == "") {
           return null;
       }

       boolean[] seen = new boolean[256];
       StringBuilder sb = new StringBuilder(seen.length);

       for (char c : input.toCharArray()) {
           if (!seen[c]) {
               sb.append(c);
               seen[c] = true;
           }
       }
       return sb.toString();
    }

    public static void main(String[] args) {
        String input = "AABCDSHEFDDEGSDVABS";
        System.out.println(removeDups2(input));
    }
}
