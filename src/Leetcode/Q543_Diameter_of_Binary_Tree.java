package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 3/25/17.
 */
public class Q543_Diameter_of_Binary_Tree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = DFS(root);
        return max[1];
    }

    // Return Height and Diameter together
    private int[] DFS(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};

        int[] leftResult = DFS(node.left);
        int[] rightResult = DFS(node.right);

        int maxHeight = Math.max(leftResult[0], rightResult[0]) + 1;
        int leftDiameter = leftResult[1];
        int rightDiameter = rightResult[1];

        int rootDiameter = leftResult[0] + rightResult[0];

        int maxDiameter = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));

        return new int[]{maxHeight, maxDiameter};


    }
}
