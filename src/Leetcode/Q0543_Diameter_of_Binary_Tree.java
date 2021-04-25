package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class Q0543_Diameter_of_Binary_Tree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode node)
    {
        if (node == null)
            return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        max = Math.max(max, left + right);
        return  Math.max(left, right) + 1;
    }
}
