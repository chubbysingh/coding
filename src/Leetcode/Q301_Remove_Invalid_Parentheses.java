package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q301_Remove_Invalid_Parentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();

        int minParenthesesToRemove = minParenthesesToRemove(s);

        dfs(s, 0, minParenthesesToRemove, 0, "", result);
        return setToList(result);
    }

    private List<String> setToList(Set<String> set) {
        List<String> result = new ArrayList<>();

        for (String str : set) {
            result.add(str);
        }
        return result;
    }

    private void dfs(String s, int index, int parentRemoveCount, int open, String temp, Set<String> result) {

        if (index == s.length()) {
            if (parentRemoveCount == 0 && open == 0) {
                result.add(temp);
                return;
            }
        }

        else if (parentRemoveCount < 0) {
            return;
        }

        else {
            if (s.charAt(index) == '(') {
                //Include
                dfs(s, index+1, parentRemoveCount, open + 1, temp + '(', result);
                //Exclude
                dfs(s, index+1, parentRemoveCount-1, open, temp, result);
            }

            else if (s.charAt(index) == ')') {
                if (open > 0) {
                    //Include
                    dfs(s, index+1, parentRemoveCount, open - 1, temp + ')', result);
                }
                //Exclude
                dfs(s, index+1, parentRemoveCount - 1, open, temp, result);
            }

            else {
                dfs(s, index+1, parentRemoveCount, open, temp + s.charAt(index), result);
            }
        }
    }

    private int minParenthesesToRemove(String s) {
        int open = 0, count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')') {
                if (open == 0) count++;
                else open--;
            }
        }
        return open + count;
    }

    public static void main(String[] args) {
        Q301_Remove_Invalid_Parentheses sol = new Q301_Remove_Invalid_Parentheses();

        String s = ")(";
        List<String> result = sol.removeInvalidParentheses(s);

        System.out.println(result);
    }
}
