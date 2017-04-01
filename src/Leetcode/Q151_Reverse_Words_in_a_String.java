package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q151_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // split to words by space
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Q151_Reverse_Words_in_a_String sol = new Q151_Reverse_Words_in_a_String();
        String input = "The sky is blue";
        String output = sol.reverseWords(input);
        System.out.println(output);
    }
}
