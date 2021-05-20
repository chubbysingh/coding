package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Return the minimum number of stickers that you need to spell out target.
 * If the task is impossible, return -1.
 *
 * Time Complexity:
 * Space Complexity:
 */

// Imp: This does not pre-process the input for leetcode. Still works.
// Pre-processing is only required to avoid TLE in Leetcode
public class Q0691_Stickers_to_Spell_Word {
    int minStickers = Integer.MAX_VALUE;

    public int minStickers(String[] stickers, String target) {
        Map<Character, Integer> map = new HashMap<>();
        dfs(stickers, target, map, 0, 0);
        return minStickers == Integer.MAX_VALUE ? -1 : minStickers;
    }

    private void dfs(String[] stickers, String target, Map<Character, Integer> map, int pos, int cnt) {
        if (cnt >= minStickers) return;
        if (pos == target.length()) {
            minStickers = Math.min(minStickers, cnt);
            return;
        }
        char t = target.charAt(pos);
        if (map.containsKey(t) && map.get(t) > 0) {
            map.put(t, map.get(t) - 1);
            dfs(stickers, target, map, pos + 1, cnt);
            map.put(t, map.get(t) + 1);
            return;
        }

        for (String sticker : stickers) {
            if (!sticker.contains(String.valueOf(t))) continue;

            for (char c : sticker.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            map.put(t, map.get(t) - 1);
            dfs(stickers, target, map, pos + 1, cnt + 1);
            map.put(t, map.get(t) + 1);

            for (char c : sticker.toCharArray()) {
                map.put(c, map.get(c) - 1);
            }
        }
    }

    public static void main(String[] args) {
        Q0691_Stickers_to_Spell_Word sol = new Q0691_Stickers_to_Spell_Word();

        String[] stickers = {"with","example","science"};
        String target = "thehat";

        int result = sol.minStickers(stickers, target);
        System.out.println(result);
    }
}
