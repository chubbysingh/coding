package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q337_House_Robber_III {

    // result[0] : Money with robbing the node
    // result[1] : Money without robbing the node

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        int[] curr = new int[2];
        curr[0] = root.val + left[1] + right[1];
        curr[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return curr;
    }
}
