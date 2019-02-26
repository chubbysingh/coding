package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Q100_Same_Tree {
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        return ((p.val == q.val)
                && isSameTreeRecursive(p.left, q.left)
                && isSameTreeRecursive(p.right, q.right));
    }

    /**
     * BFS on both the Trees
     */
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        // Return true if both trees are empty
        if (p == null && q == null)
            return true;

        // Return false if one is empty and other is not
        else if (p == null || q == null)
            return false;

        // Create an empty queues for simultaneous traversals
        Queue<TreeNode > q1 = new LinkedList<> ();
        Queue<TreeNode> q2 = new LinkedList<>();

        // Enqueue Roots of trees in respective queues
        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // Get front nodes and compare them
            TreeNode n1 = q1.peek();
            TreeNode n2 = q2.peek();

            if (n1.val != n2.val)
                return false;

            // Remove front nodes from queues
            q1.remove();
            q2.remove();

            /* Enqueue left children of both nodes */
            if (n1.left != null && n2.left != null) {
                q1.add(n1.left);
                q2.add(n2.left);
            }
            else if (n1.left != null || n2.left != null) {
                return false;
            }

            // Right child code (Similar to left child code)
            if (n1.right != null && n2.right != null) {
                q1.add(n1.right);
                q2.add(n2.right);
            }
            else if (n1.right != null || n2.right != null)
                return false;
        }
        return true;
    }
}
