package Leetcode;

import java.util.Arrays;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q455_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChild = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                contentChild++;
                i++;
            }
        }

        return contentChild;
    }
}
