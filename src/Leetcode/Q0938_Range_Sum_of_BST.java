package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with a value in the range [low, high].
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 */
public class Q0938_Range_Sum_of_BST {
    /**
     * Recursive solution using DFS
     */
    int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return ans;
    }

    private void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            // L <= node.val <= R
            if (L <= node.val && node.val <= R)
            ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }

    /**
     * Iterative Solution using BFS
     */
    public int rangeSumBSTIterative(TreeNode root, int L, int R) {
        int sum = 0;
        if (root == null) {
            return sum;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current.val >= L && current.val <= R) {
                sum += current.val;
            }

            if (current.left != null && current.val >= L) {
                queue.add(current.left);
            }

            if (current.right != null && current.val <= R) {
                queue.add(current.right);
            }
        }

        return sum;
    }
}
