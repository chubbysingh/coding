package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q104_Maximum_Depth_of_Binary_Tree {
    public int maxDepthRecursive(TreeNode root) {
        if (root == null)
            return 0;

        int leftMost = 1 + maxDepthRecursive(root.left);
        int rightMost = 1 + maxDepthRecursive(root.right);

        return Math.max(leftMost, rightMost);
    }

    public int maxDepthIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count=0;

        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return count;
    }
}
