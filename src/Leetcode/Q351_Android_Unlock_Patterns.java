package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given Android 9 key lock screen and numbers m and n, where 1 <= m <= n <= 9 .
 * Count the total number of patterns of Android lock screen,
 * which consist of minimum of m keys and maximum n keys.
 * <p>
 * Example:
 * <p>
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Valid move : 6 - 5 - 4 - 1 - 9 - 2
 * <p>
 * Line 1 - 9 is valid because it pass through key 5, which has been already selected in the pattern
 * Valid move : 2 - 4 - 1 - 3 - 6
 * <p>
 * Line 1 - 3 is valid because it pass through key 2, which has been already selected in the pattern
 * Invalid move : 4 - 1 - 3 - 6
 * <p>
 * Line 1 - 3 pass through key 2 which is not still selected in the pattern
 * Invalid move : 4 - 1 - 9 - 2
 * <p>
 * Line 1 - 9 pass through key 5 which is not still selected in the pattern
 */

public class Q351_Android_Unlock_Patterns {
    private int patterns;

    private boolean valid(boolean[] keypad, int from, int to) {
        if (from == to) return false;
        int i = Math.min(from, to), j = Math.max(from, to);
        if ((i == 1 && j == 9) || (i == 3 && j == 7)) return keypad[5] && !keypad[to];
        if ((i == 1 || i == 4 || i == 7) && i + 2 == j) return keypad[i + 1] && !keypad[to];
        if (i <= 3 && i + 6 == j) return keypad[i + 3] && !keypad[to];
        return !keypad[to];
    }

    private void find(boolean[] keypad, int from, int step, int m, int n) {
        if (step == n) {
            patterns++;
            return;
        }
        if (step >= m) patterns++;
        for (int i = 1; i <= 9; i++) {
            if (valid(keypad, from, i)) {
                keypad[i] = true;
                find(keypad, i, step + 1, m, n);
                keypad[i] = false;
            }
        }
    }

    public int numberOfPatterns(int m, int n) {
        boolean[] keypad = new boolean[10];
        for (int i = 1; i <= 9; i++) {
            keypad[i] = true;
            find(keypad, i, 1, m, n);
            keypad[i] = false;
        }
        return patterns;
    }

}
