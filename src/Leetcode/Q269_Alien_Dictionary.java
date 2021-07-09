package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 3/15/17.
 */
public class Q269_Alien_Dictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.put(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                String word1 = words[i];
                String word2 = words[j];

                for (int k = 0; k < Math.min(word1.length(), word2.length()); k++) {

                    if (word1.charAt(k) != word2.charAt(k)) {

                        /*if (!adjList.containsKey(word2.charAt(k))) {
                            adjList.put(word2.charAt(k), new HashSet<>());
                        }*/
                        adjList.get(word2.charAt(k)).add(word1.charAt(k));
                        break;
                    }

                }
            }
        }

        Set<Character> processed = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        StringBuffer result = new StringBuffer();

        for (char c : adjList.keySet()) {
            if (!dfs(adjList, c, visited, processed, result)) {
                return new String();
            }
        }

        return result.toString();
    }

    private boolean dfs(Map<Character, Set<Character>> adjList, char c, Set<Character> visited, Set<Character> processed, StringBuffer result) {
        if (processed.contains(c)) return true;
        else if (visited.contains(c)) return false;
        else visited.add(c);

        if (!adjList.containsKey(c)) {
            result.append(c);
            return true;
        }

        processed.add(c);
        result.append(c);
        return true;
    }


    public static void main(String[] args) {
        Q269_Alien_Dictionary sol = new Q269_Alien_Dictionary();
        //String[] words = {"abc","ab"};
        String[] words = {"wrt","wrf","er","ett","rftt"};

        String result = sol.alienOrder(words);
        System.out.println(result);
    }
}


