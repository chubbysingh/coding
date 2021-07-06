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
public class Q0737_Sentence_Similarity_II {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> similar : similarPairs) {
            graph.putIfAbsent(similar.get(0), new HashSet<>());
            graph.putIfAbsent(similar.get(1), new HashSet<>());
            graph.get(similar.get(0)).add(similar.get(1));
            graph.get(similar.get(1)).add(similar.get(0));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;
            if (!graph.containsKey(sentence1[i])) return false;
            if (!dfs(graph, sentence1[i], sentence2[i], new HashSet<>())) return false;
        }

        return true;
    }

    private boolean dfs(Map<String, Set<String>> graph, String source, String target, Set<String> visited) {
        if (graph.get(source).contains(target)) return true;

        if (visited.add(source)) {
            for (String next : graph.get(source)) {
                if (!visited.contains(next) && dfs(graph, next, target, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q0737_Sentence_Similarity_II sol = new Q0737_Sentence_Similarity_II();

        String[] sentence1 = {"great","acting","skills"};
        String[] sentence2 = {"fine","drama","talent"};
        List<List<String>> similarPairs = Arrays.asList(
                Arrays.asList("great","good"), Arrays.asList("fine","good"), Arrays.asList("drama","acting"), Arrays.asList("skills","talent"));

        boolean result = sol.areSentencesSimilarTwo(sentence1, sentence2, similarPairs);
        System.out.println(result);
    }
}
