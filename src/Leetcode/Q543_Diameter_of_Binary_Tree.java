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
public class Q543_Diameter_of_Binary_Tree {
    public int diameterOfBinaryTree(TreeNode root) {
        return DFS(root)[0];
    }

    // int[2] = [dia, height]
    private int[] DFS(TreeNode node)
    {
        if (node == null) return new int[] { 0, 0 };
        int[] left = DFS(node.left);
        int[] right = DFS(node.right);

        int dia = Math.max(left[1] + right[1], Math.max(left[0], right[0]));
        int height = 1 + Math.max(left[1], right[1]);
        return new int[] { dia, height };
    }
}
