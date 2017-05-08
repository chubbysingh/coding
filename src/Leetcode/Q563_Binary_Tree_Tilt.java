package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 5/6/17.
 */
public class Q563_Binary_Tree_Tilt {
    int result = 0;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        result += Math.abs(left - right);

        return left + right + root.val;
    }
}
