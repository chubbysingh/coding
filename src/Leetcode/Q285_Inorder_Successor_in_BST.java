package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a binary search tree and a node in it,
 * find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree,
 * return null.
 */
public class Q285_Inorder_Successor_in_BST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        // Case 1: p.right != null
        if (p.right != null) {
            return findMin(p.right);
        }

        // Case 2: p.right == null
        TreeNode succ = null;
        TreeNode q = root;

        while (q != null) {
            if (q.val > p.val) {
                succ = q;
                q = q.left;
            } else if (q.val < p.val) {
                q = q.right;
            } else {
                break;
            }
        }

        return succ;
    }

    private TreeNode findMin(TreeNode root) {
        TreeNode p = root;

        while (p.left != null) {
            p = p.left;
        }

        return p;
    }
}
