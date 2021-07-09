package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q140_Word_Break_II {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordDict);

        dfs(s, dict, result, "");
        return result;
    }

    private void dfs(String s, Set<String> wordDict, List<String> result, String temp) {

        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            String right = i == s.length() ? "" : s.substring(i);

            if (wordDict.contains(left)) {
                if (right.isEmpty()) {
                    temp += " " + left;
                    result.add(temp.trim());
                    return;
                }

                dfs(right, wordDict, result, temp + " "+ left);
            }
        }
    }

    public static void main(String[] args) {
        Q140_Word_Break_II sol = new Q140_Word_Break_II();

        List<String> wordDict = Arrays.asList(new String[]{"cat","cats","and","sand","dog"});
        String s = "catsanddog";

        List<String> result = sol.wordBreak(s, wordDict);
        System.out.println(result);
    }
}
