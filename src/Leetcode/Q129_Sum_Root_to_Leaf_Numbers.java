package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 * <p>
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class Q129_Sum_Root_to_Leaf_Numbers {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode node, int sum) {
        if (node == null)
            return 0;

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null)
            return sum;

        return sum(node.left, sum) + sum(node.right, sum);
    }
}
