package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 3/5/17.
 */
public class Q530_Minimum_Absolute_Difference_in_BST {
    int result = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;

        getMinimumDifference(root.left);

        if (prev != null) {
            result = Math.min(result, root.val - prev.val);
        }
        prev = root;

        getMinimumDifference(root.right);

        return result;
    }
}
