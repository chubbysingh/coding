package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given two sentences sentence1 and sentence2 each represented as a string array
 * and given an array of string pairs similarPairs
 * where similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.
 *
 * Two sentences are similar if:
 *
 * They have the same length (i.e., the same number of words)
 * sentence1[i] and sentence2[i] are similar.
 */
public class Q0734_Sentence_Similarity {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> similar : similarPairs) {
            if (!map.containsKey(similar.get(0))) {
                map.put(similar.get(0), new HashSet<>());
            }
            map.get(similar.get(0)).add(similar.get(1));

            if (!map.containsKey(similar.get(1))) {
                map.put(similar.get(1), new HashSet<>());
            }
            map.get(similar.get(1)).add(similar.get(0));
        }

        for (int i = 0; i < sentence1.length; i++) {

            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if (word1.equals(word2)) continue;

            if (!map.containsKey(word1)) return false;
            if (!map.get(word1).contains(word2)) return false;

        }
        return true;
    }

    public static void main(String[] args) {
        Q0734_Sentence_Similarity sol = new Q0734_Sentence_Similarity();

        String[] sentence1 = {"great","acting","skills"};
        String[] sentence2 = {"fine","drama","talent"};
        List<List<String>> similarPairs = Arrays.asList(
                Arrays.asList("great","fine"), Arrays.asList("drama","acting"), Arrays.asList("skills","talent"));

        boolean result = sol.areSentencesSimilar(sentence1, sentence2, similarPairs);
        System.out.println(result);
    }
}
