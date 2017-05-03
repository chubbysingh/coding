package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q052_N_Queens_II {
    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }

    public List<List<String>> solveNQueens(int n) {
        int[] nums = new int[n];
        List<List<String>> ans = new ArrayList<List<String>>();
        int i = 0;
        while (true) {
            if (i < 0) {
                return ans;
            }
            if (i == n) {
                List<String> list = new ArrayList<String>();
                for (int j = 0; j < nums.length; j++) {
                    StringBuffer sb = new StringBuffer();
                    for (int k = 0; k < n; k++) {
                        if (k != nums[j]) {
                            sb.append(".");
                        } else {
                            sb.append("Q");
                        }
                    }
                    list.add(sb.toString());
                }
                ans.add(list);
                i--;
                while (nums[i] == n) {
                    nums[i] = 0;
                    i--;
                }
                nums[i]++;
            } else {
                if (nums[i] == n) {
                    while (i >= 0 && nums[i] == n) {
                        nums[i] = 0;
                        i--;
                    }
                    if (i >= 0) {
                        nums[i]++;
                    }
                } else {
                    if (f(nums, i, nums[i])) {
                        i++;
                    } else {
                        nums[i]++;
                    }
                }
            }

        }
//        return ans;
    }

    public boolean f(int[] nums, int x, int val) {
        for (int i = 0; i < x; i++) {
            int t = x - i;
            if (val == nums[i] || val == nums[i] + t || val == nums[i] - t) {
                return false;
            }
        }
        return true;
    }
}
