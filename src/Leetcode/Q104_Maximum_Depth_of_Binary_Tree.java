package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftMost = 1 + maxDepth(root.left);
        int rightMost = 1 + maxDepth(root.right);

        return Math.max(leftMost, rightMost);
    }
}
