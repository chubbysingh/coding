package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language,
 * and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographically
 * in this alien language.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 */
public class Q0953_Verifying_an_Alien_Dictionary {
    private Map<Character, Integer> orderMap;
    public boolean isAlienSorted(String[] words, String order) {
        orderMap = computeMap(order);

        for (int i=0; i < words.length - 1; i++) {
            if (isFirstWordLargerThanSecond(words[i], words[i+1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isFirstWordLargerThanSecond(String word1, String word2) {
        int idx1 = 0, idx2 = 0;

        while (idx1 < word1.length() && idx2 < word2.length()) {
            if (orderMap.get(word1.charAt(idx1)) > orderMap.get(word2.charAt(idx2)) ) {
                return true;
            } else if (orderMap.get(word1.charAt(idx1)) < orderMap.get(word2.charAt(idx2)) ) {
                return false;
            }
            idx1++;
            idx2++;
        }
        // First word will be larger than second if
        // first word is bigger in length than second
        // e.g. facebook > face
        return word1.length() > word2.length() ;
    }

    private Map<Character, Integer> computeMap(String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i=0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        return orderMap;
    }

    public static void main(String[] args) {
        Q0953_Verifying_an_Alien_Dictionary sol = new Q0953_Verifying_an_Alien_Dictionary();
        String[] words = {"words","word"};
        String order = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(sol.isAlienSorted(words, order));

    }
}
