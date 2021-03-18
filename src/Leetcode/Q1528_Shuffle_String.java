package Leetcode;

/**
 * Given a string s and an integer array indices of the same length.
 *
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 *
 */
public class Q1528_Shuffle_String {

    public String restoreString(String s, int[] indices) {
        if (null == s || s.isEmpty())
            return s;

        char[] chArr = new char[indices.length];

        for (int i=0; i < indices.length; i++) {
            int index = indices[i];
            char c = s.charAt(i);
            chArr[index] = c;
        }
        return String.valueOf(chArr);
    }

    public static void main(String[] args) {
        Q1528_Shuffle_String sol = new Q1528_Shuffle_String();

        int[] indices = {4, 5, 6, 7, 0, 1, 2, 3};
        String str = "bookface";

        String result = sol.restoreString(str, indices);
        System.out.println(result);
    }
}
