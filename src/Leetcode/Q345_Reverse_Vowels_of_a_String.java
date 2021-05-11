package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chArray = s.toCharArray();
        int start = 0,
                end = chArray.length - 1;

        while (start < end) {
            if (!isVowel(chArray[start])) {
                start++;
            }

            else if (!isVowel(chArray[end])) {
                end--;
            }

            else {
                Character tmp = chArray[start];
                chArray[start] = chArray[end];
                chArray[end] = tmp;

                start++;
                end--;
            }
        }
        return new String(chArray);
    }

    private boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        Q345_Reverse_Vowels_of_a_String sol = new Q345_Reverse_Vowels_of_a_String();
        String result = sol.reverseVowels("hello");
        System.out.println(result);
    }
}
