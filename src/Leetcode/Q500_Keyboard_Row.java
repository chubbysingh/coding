package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 2/11/17.
 */
public class Q500_Keyboard_Row {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0)
            return new String[]{};

        List<String> res = new LinkedList<String>();
        Map<Character, Integer> map = buildMap();

        for (String str : words) {
            char firstChar = Character.toUpperCase(str.charAt(0));
            int index = map.get(firstChar);
            boolean isSameLine = true;
            for (char ch : str.toCharArray()) {
                char upperCaseChar = Character.toUpperCase(ch);
                if (map.get(upperCaseChar) != index) {
                    isSameLine = false;
                    break;
                }

            }
            if (isSameLine)
                res.add(str);
        }
        return res.toArray(new String[res.size()]);
    }

    private Map<Character, Integer> buildMap() {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String[] str = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        for (int i = 0; i < str.length; i++) {
            for (char c : str[i].toCharArray()) {
                map.put(c, i);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Q500_Keyboard_Row sol = new Q500_Keyboard_Row();
        String[] ans = sol.findWords(new String[]{"adsdf", "sfd"});
        System.out.println(ans);

    }
}
