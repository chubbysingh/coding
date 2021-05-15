package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given a binary search tree (BST),
 * find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 */
public class Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // Identify smaller and larger values first
        int smaller, larger;
        if (p.val < q.val) {
            smaller = p.val;
            larger = q.val;
        } else {
            smaller = q.val;
            larger = p.val;
        }

        // rest is easy
        if (root.val >= smaller && root.val <= larger)
            return root;
        else if (root.val <= smaller)
            return lowestCommonAncestor(root.right, p, q);
        else
            return lowestCommonAncestor(root.left, p, q);
    }
}
