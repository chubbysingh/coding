package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            TreeNode rChild = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode rMost = root.right;
            while (rMost.right != null) {
                rMost = rMost.right;
            }
            rMost.right = rChild;
        }

        flatten(root.right);
    }

    public void flattenIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode p = root;

        while (p != null || !stack.empty()) {
            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.empty()) {
                TreeNode temp = stack.pop();
                p.right = temp;
            }

            p = p.right;
        }
    }

    public void flattenIterativeTwo(TreeNode root) {
        if (root == null) return;
        TreeNode p = root;

        while (p.left != null || p.right != null) {
            if (p.left != null) {
                TreeNode rChild = p.right;
                p.right = p.left;
                p.left = null;
                TreeNode rMost = p.right;
                while (rMost.right != null) {
                    rMost = rMost.right;
                }
                rMost.right = rChild;
            }

            p = p.right;
        }
    }


}
