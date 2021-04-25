package Leetcode;

/**
 * Given a VPS represented as string s, return the nesting depth of s.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 */
public class Q1614_Maximum_Nesting_Depth_of_the_Parentheses {

    public int maxDepth(String s) {
        int res = 0, cur = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                cur++;
                res = Math.max(res, cur);
            }

            if (s.charAt(i) == ')')
                cur--;
        }
        return res;
    }

    public static void main(String[] args) {
        Q1614_Maximum_Nesting_Depth_of_the_Parentheses sol = new Q1614_Maximum_Nesting_Depth_of_the_Parentheses();

        String s = "(1+(2*3)+((8)/4))+1";

        int result = sol.maxDepth(s);
        System.out.println(result);
    }
}
