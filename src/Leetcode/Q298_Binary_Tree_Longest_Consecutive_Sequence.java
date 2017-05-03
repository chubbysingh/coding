package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * <p>
 * The path refers to any sequence of nodes from some starting node
 * to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 */

public class Q298_Binary_Tree_Longest_Consecutive_Sequence {

    int max = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;

        int l = helper(root.left);
        int r = helper(root.right);

        int fromLeft = 0;
        int fromRight = 0;

        if (root.left == null) {
            fromLeft = 1;
        } else if (root.left.val - 1 == root.val) {
            fromLeft = l + 1;
        } else {
            fromLeft = 1;
        }

        if (root.right == null) {
            fromRight = 1;
        } else if (root.right.val - 1 == root.val) {
            fromRight = r + 1;
        } else {
            fromRight = 1;
        }

        max = Math.max(max, fromLeft);
        max = Math.max(max, fromRight);

        return Math.max(fromLeft, fromRight);
    }

    public int longestConsecutiveIterative(TreeNode root) {
        if (root == null)
            return 0;

        LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        LinkedList<Integer> sizeQueue = new LinkedList<Integer>();

        nodeQueue.offer(root);
        sizeQueue.offer(1);
        int max = 1;

        while (!nodeQueue.isEmpty()) {
            TreeNode head = nodeQueue.poll();
            int size = sizeQueue.poll();

            if (head.left != null) {
                int leftSize = size;
                if (head.val == head.left.val - 1) {
                    leftSize++;
                    max = Math.max(max, leftSize);
                } else {
                    leftSize = 1;
                }

                nodeQueue.offer(head.left);
                sizeQueue.offer(leftSize);
            }

            if (head.right != null) {
                int rightSize = size;
                if (head.val == head.right.val - 1) {
                    rightSize++;
                    max = Math.max(max, rightSize);
                } else {
                    rightSize = 1;
                }

                nodeQueue.offer(head.right);
                sizeQueue.offer(rightSize);
            }


        }

        return max;
    }
}
