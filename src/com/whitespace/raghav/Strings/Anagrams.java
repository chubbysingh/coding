package com.whitespace.raghav.Strings;

import java.util.*;

/**
 * Created by rbhatnagar2 on 6/14/15.
 * Print all pairs of anagrams in a given array of strings
 * <p>
 * Input: arr[] =  {"geeksquiz", "geeksforgeeks", "abcd","forgeeksgeeks", "zuiqkeegs"};
 * Output: (geeksforgeeks, forgeeksgeeks), (geeksquiz, zuiqkeegs)
 */
public class Anagrams {

    public void printAnagrams(String[] arr) {

        Map<String, List<String>> pairs = buildMap(arr);

    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    private Map buildMap(String[] arr) {
        Map<String, List<String>> pairs = new HashMap<String, List<String>>();
        for (String s : arr) {

            String sorted = sort(s);
            if (pairs.containsKey(sorted)) {
                List<String> values = pairs.get(sorted);
                values.add(s);
                pairs.put(sorted, values);
            } else {
                List<String> values = new ArrayList<String>();
                values.add(s);
                pairs.put(sorted, values);
            }
        }
        return pairs;
    }
}
