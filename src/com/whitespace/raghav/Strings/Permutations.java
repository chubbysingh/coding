package com.whitespace.raghav.Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 9/8/15.
 */
public class Permutations {

    private static Set<String> generatePerm(String input) {
        Set<String> set = new HashSet<String>();
        if (input == "") {
            return set;
        }

        Character a = input.charAt(0);

        if (input.length() > 1) {
            input = input.substring(1);

            Set<String> permSet = generatePerm(input);

            for (String x : permSet) {
                for (int i = 0; i <= x.length(); i++) {
                    set.add(x.substring(0, i) + a + x.substring(i));
                }
            }
        } else {
            set.add(a + "");
        }
        return set;

    }

    public static void main(String[] args) {
        String input = "ABC";

        Set<String> perm = generatePerm(input);

        for (String x : perm) {
            System.out.println(x);
        }
    }
}
