package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a non-empty binary search tree and a target value,
 * find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 */
public class Q270_Closest_Binary_Search_Tree_Value {

    public int closestValue(TreeNode root, double target) {
        if (root == null)
            return -1;

        int result = root.val;
        while (root != null) {
            if (Math.abs(result - target) > Math.abs(root.val - target)) {
                result = root.val;
            }

            if (target < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return result;
    }

    public int closestValueIterative(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int result = root.val;

        while (root != null) {
            if (target > root.val) {

                double diff = Math.abs(root.val - target);
                if (diff < min) {
                    min = Math.min(min, diff);
                    result = root.val;
                }
                root = root.right;
            } else if (target < root.val) {

                double diff = Math.abs(root.val - target);
                if (diff < min) {
                    min = Math.min(min, diff);
                    result = root.val;
                }
                root = root.left;
            } else {
                return root.val;
            }
        }

        return result;
    }
}
