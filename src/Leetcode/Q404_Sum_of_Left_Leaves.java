package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q404_Sum_of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                ans += root.left.val;
            else
                ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }
}
