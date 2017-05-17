package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;

        else if (left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    // Iterative
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> lQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> rQueue = new LinkedList<TreeNode>();

        lQueue.offer(root);
        rQueue.offer(root);

        while (!lQueue.isEmpty() && !rQueue.isEmpty()) {
            TreeNode curLeft = lQueue.poll();
            TreeNode curRight = rQueue.poll();
            if (curLeft.val != curRight.val) {
                return false;
            }

            // Left, Right in leftQueue
            if (curLeft.left != null) {
                lQueue.offer(curLeft.left);
            }
            if (curLeft.right != null) {
                rQueue.offer(curLeft.right);
            }

            // Right, Left in rightQueue
            if (curRight.right != null) {
                rQueue.offer(curRight.right);
            }
            if (curRight.left != null) {
                lQueue.offer(curRight.left);
            }
        }

        if (!lQueue.isEmpty() || !rQueue.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
}
