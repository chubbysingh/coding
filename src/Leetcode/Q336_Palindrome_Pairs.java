package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q336_Palindrome_Pairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }

        for(int i = 0; i < words.length; i++){
            int l = 0, r = 0;
            while(l <= r){
                String s = words[i].substring(l, r);
                Integer j = map.get(new StringBuilder(s).reverse().toString());
                if(j != null && j != i && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l))){
                    pairs.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
                }
                if(r < words[i].length()) r++;
                else l++;
            }
        }
        return pairs;
    }

    private boolean isPalindrome(String s) {
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}
