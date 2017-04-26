package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q226_Invert_Binary_Tree {
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null)
            return null;

        TreeNode invert = new TreeNode(root.val);
        invert.right = invertTreeRecursive(root.left);
        invert.left = invertTreeRecursive(root.right);

        return invert;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // swap left and right children
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

        }
        return root;
    }
}
