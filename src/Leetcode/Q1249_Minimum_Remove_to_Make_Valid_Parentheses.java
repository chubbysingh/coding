package Leetcode;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')',
 * in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Time complexity : O(n), where n is the length of the input string.
 * Space complexity : O(n), where n is the length of the input string.
 */
public class Q1249_Minimum_Remove_to_Make_Valid_Parentheses {

    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) continue;
                open--;
            }
            sb.append(c);
        }

        if (open == 0) {
            return sb.toString();
        }

        StringBuilder result = new StringBuilder();
        for (int i = sb.length()-1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open > 0) {
                open--;
                continue;
            }
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Q1249_Minimum_Remove_to_Make_Valid_Parentheses sol = new Q1249_Minimum_Remove_to_Make_Valid_Parentheses();

        String str = "lee(t(c)o)de)(";

        String result = sol.minRemoveToMakeValid(str);
        System.out.println(result);
    }
}
