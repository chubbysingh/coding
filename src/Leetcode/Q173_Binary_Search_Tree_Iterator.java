package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q173_Binary_Search_Tree_Iterator {
    private Stack<TreeNode> stack;

    // constructor
    public Q173_Binary_Search_Tree_Iterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        if (res.right != null) {
            TreeNode curr = res.right;
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return res.val;
    }
}
