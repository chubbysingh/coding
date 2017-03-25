package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q060_Permutation_Sequence {
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return "";
        }

        List<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }

        // calculate the factorial
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            int index = k / factorial;
            sb.append(num.get(index));

            num.remove(index);

            // update current k
            k %= factorial;
        }

        return sb.toString();
    }
}
