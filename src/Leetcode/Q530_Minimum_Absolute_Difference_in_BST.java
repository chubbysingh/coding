package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 3/5/17.
 */
public class Q530_Minimum_Absolute_Difference_in_BST {
    int result = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifferenceRecursive(TreeNode root) {
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

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;

        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null)
                    min = Math.min(min, cur.val - pre.val);
                pre = cur;
                cur = cur.right;
            }
        }
        return min;
    }
}
