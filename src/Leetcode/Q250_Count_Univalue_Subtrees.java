package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * For example:
 * Given binary tree,
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * return 4.
 */
public class Q250_Count_Univalue_Subtrees {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        countUnivalSubtreesHelper(root);

        return count;
    }

    private int countUnivalSubtreesHelper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Divide
        int left = countUnivalSubtreesHelper(root.left);
        int right = countUnivalSubtreesHelper(root.right);

        // left and right are all empty
        if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
            count++;
            return root.val;
        } else if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) {
            if (root.val == left || root.val == right) {
                count++;
                return root.val;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            if (root.val == left && root.val == right) {
                count++;
                return root.val;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }
}
