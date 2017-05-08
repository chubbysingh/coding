package com.whitespace.raghav.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 9/8/15.
 */
public class MaxOccurence {

    private static Data maxOccurance(String input) {
        if (input == null || input == "")
            return null;

        int maxCount = 0;
        Character maxCharacter = null;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxCharacter = entry.getKey();
            }
        }

        return new Data(maxCharacter, maxCount);
    }

    public static void main(String[] args) {
        String input = "test";
        System.out.println(maxOccurance(input));
    }
}

class Data {
    Character c;
    Integer count;

    Data(Character c, Integer count) {
        this.c = c;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Data{" +
                "c=" + c +
                ", count=" + count +
                '}';
    }
}
