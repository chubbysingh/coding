package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 5/6/17.
 */
public class Q563_Binary_Tree_Tilt {
    public int findTilt(TreeNode root) {
        int[] ret = new int[1];
        helper(root, ret);
        return ret[0];
    }

    private int helper(TreeNode node, int[] ret){
        if(node == null){
            return 0;
        }
        int l_sum = helper(node.left, ret);
        int r_sum = helper(node.right, ret);
        ret[0] += Math.abs(l_sum - r_sum);
        return l_sum + r_sum + node.val;
    }
}
