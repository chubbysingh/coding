package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * https://leetcode.com/problems/anagrams/
 */
public class Q0049_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);

            String sortedString = new String(chArr);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new LinkedList<String>());
            }

            map.get(sortedString).add(str);
        }

        for (List<String> groupedStrings : map.values()) {
            result.add(groupedStrings);
        }
        return result;
    }

    public static void main(String[] args) {
        Q0049_Group_Anagrams sol = new Q0049_Group_Anagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = sol.groupAnagrams(strs);
        System.out.println(result);
    }
}
