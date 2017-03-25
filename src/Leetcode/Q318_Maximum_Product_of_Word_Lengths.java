package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q318_Maximum_Product_of_Word_Lengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }

        int n = words.length;
        int[] encodedWords = new int[n];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                encodedWords[i] |= (1 << (c - 'a'));
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((encodedWords[i] & encodedWords[j]) == 0) {
                    maxLen = Math.max(maxLen,
                            words[i].length() * words[j].length());
                }
            }
        }

        return maxLen;
    }
}
