package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int start=0, end=s.length()-1;
        char[] cArr = s.toCharArray();

        while (start < end) {
            if(!vowels.contains(cArr[start])) {
                start++;
            }
            if(!vowels.contains(cArr[end])) {
                end--;
            }
            if(vowels.contains(cArr[start]) && vowels.contains(cArr[end])) {
                Character tmp = cArr[start];
                cArr[start] = cArr[end];
                cArr[end] = tmp;
                start++;
                end--;
            }
        }
        return new String(cArr);

    }
}
