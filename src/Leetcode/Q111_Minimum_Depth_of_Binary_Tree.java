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
        else if (root.left == null) return minDepthRecursive(root.right) + 1;
        else if (root.right == null) return minDepthRecursive(root.left) + 1;
        else {
            return Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right)) + 1;
        }
    }

    public int minDepthIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int min = 0;
        while (!queue.isEmpty()) {
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
