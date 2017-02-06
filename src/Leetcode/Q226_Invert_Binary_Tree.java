package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode invert = new TreeNode(root.val);
        invert.right = invertTree(root.left);
        invert.left = invertTree(root.right);

        return invert;
    }
}
