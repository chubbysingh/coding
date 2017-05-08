package com.whitespace.raghav.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Rearrange characters in a string so that no character repeats twice.
 * <p>
 * Input: aaabc
 * Output: abaca
 * <p>
 * Input: aa
 * Output: No valid output
 * <p>
 * Input: aaaabc
 * Output: No valid output
 * <p>
 * Created by rbhatnagar2 on 10/22/15.
 */
public class Rearrange {

    private static Map<Character, Integer> buildMap(String input) {
        if (input == null || input.length() == 0)
            return null;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : input.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        return map;
    }

    private static String rearrange(Map<Character, Integer> map, int size) {
        if (map == null)
            return null;
        char[] chars = new char[size];
        int indexToPlace = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > size / 2)
                return null;
            for (int i = 0; i < entry.getValue(); i++) {

                chars[indexToPlace] = entry.getKey();
                if (indexToPlace + 2 < size)
                    indexToPlace += 2;
                else
                    indexToPlace = 1;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String input = "daaaabc";
        Map<Character, Integer> map = buildMap(input);
        String output = rearrange(map, input.length());
        if (output != null)
            System.out.println(output);
        else
            System.out.println("Invalid Input");
    }

}
