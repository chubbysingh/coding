package Leetcode;

/**
 * Given a string S of lowercase letters,
 * a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 * Input: "abbaca"
 * Output: "ca"
 *
 */
public class Q1047_Remove_All_Adjacent_Duplicates_in_String {

    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q1047_Remove_All_Adjacent_Duplicates_in_String sol = new Q1047_Remove_All_Adjacent_Duplicates_in_String();

        String str = "abbaca";
        String result = sol.removeDuplicates(str);
        System.out.println(result);
    }
}
