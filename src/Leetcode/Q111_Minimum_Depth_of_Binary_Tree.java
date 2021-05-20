package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q111_Minimum_Depth_of_Binary_Tree {
    public int minDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepthRecursive(root.right) + 1;
        if (root.right == null) return minDepthRecursive(root.left) + 1;
        return Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right)) + 1;
    }

    public int minDepthRecursiveTwo(TreeNode root) {
        if (root == null) return 0;
        int left = minDepthRecursiveTwo(root.right) + 1;
        int right = minDepthRecursiveTwo(root.left) + 1;

        if (left == 0 || right == 0) {
            return 1 + right + left;
        }
        return Math.min(minDepthRecursiveTwo(root.left), minDepthRecursiveTwo(root.right)) + 1;
    }

    public int minDepthIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int min = 0;
        while (!queue.isEmpty()) {
            //sizeofQueue is the # of elements at every level
            int sizeOfQueue = queue.size();
            min++;

            for (int i = 0; i < sizeOfQueue; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return min;
                else {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
        }
        return min;
    }
}
