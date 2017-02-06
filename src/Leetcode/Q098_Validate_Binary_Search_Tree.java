package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q098_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean isValidBST(TreeNode root, double min, double max) {
        if (root == null)
            return true;
        else if (root.val <= min || root.val >= max)
            return false;

        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }
}
