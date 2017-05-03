package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * https://www.youtube.com/watch?v=YDf982Lb84o
 */
public class Q096_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int T[] = new int[n + 1];
        T[0] = 1;
        T[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                T[i] += T[j] * T[i - j - 1];
            }
        }
        return T[n];
    }
}
