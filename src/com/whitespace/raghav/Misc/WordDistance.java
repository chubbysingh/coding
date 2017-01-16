package com.whitespace.raghav.Misc;

/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 *   assert(finder.distance("fox","the") == 3);
 *   assert(finder.distance("quick", "fox") == 1);
 *
 *  http://www.careercup.com/question?id=5725709041401856
  *
 *   Created by rbhatnagar2 on 10/21/15.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {

    //O(n) --> Useful when the method is called only once
    private static int distanceFinder(String[] words, String word1, String word2) {

        if (words == null || words.length == 0 || word1 == null || word2 == null)
            return -1;
        if (word1.equals(word2))
            return 0;

        int index1 = -1;
        int index2 = -1;

        int minimumDistance = Integer.MAX_VALUE;

        for (int i = 0 ; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }

            if ((words[i].equals(word1) || words[i].equals(word2)) &&
                    index1 != -1 && index2 != -1) {
                int newDistance = Math.abs(index1 - index2);
                minimumDistance = Math.min(minimumDistance, newDistance);
            }
        }
        return minimumDistance;
    }

    private int distanceFinderUsingHashMap(String[] words, String word1, String word2) {
        return -1;
    }

    private Map<String, List<Integer>> buildMap(String[] words) {
        if (words == null || words.length == 0)
            return null;

        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0 ; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                List<Integer> newList = map.get(words[i]);
                newList.add(i);
                map.put(words[i], newList);
            } else {
                List<Integer> newList = Arrays.asList(i);
                map.put(words[i], newList);
            }
        }
        return map;
    }

    private static int getMinimumDistance(Map<String, List<Integer>> map, String word1, String word2) {
        if (map == null || word1 == null || word2 == null)
            return -1;

        if (word1.equals(word2))
            return 0;

        int minimumDistance = Integer.MAX_VALUE;
        List<Integer> occurrencesOfWord1 = map.get(word1);
        List<Integer> occurrencesOfWord2 = map.get(word2);

        int index1 = 0, index2 = 0;

        while (index1 < occurrencesOfWord1.size() && index2 < occurrencesOfWord2.size()) {
            int currentIndex1 = occurrencesOfWord1.get(index1);
            int currentIndex2 = occurrencesOfWord2.get(index2);

            int newDistance = Math.abs(currentIndex1 - currentIndex2);
            minimumDistance = Math.min(minimumDistance, newDistance);

            if (index1 < index2)
                index1++;
            else
                index2++;
        }

        if (index1 < occurrencesOfWord1.size()) {
            /*int currentIndex2 = occurrencesOfWord2.get(index2+1);
            int newDistance = Math.abs(currentIndex1 - currentIndex2);
            minimumDistance = Math.min(minimumDistance, newDistance);*/
        }

        return minimumDistance;
    }

    public static void main(String[] args) {
        String[] input = {"The", "Quick", "Brown", "Fox", "Jumps", "The"};
        int minimumDistance = distanceFinder(input, "Jumps", "The");
        System.out.println(minimumDistance);


    }
}
