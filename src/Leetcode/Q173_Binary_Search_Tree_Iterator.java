package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q173_Binary_Search_Tree_Iterator {
    Stack<TreeNode> stack;
    public Q173_Binary_Search_Tree_Iterator(TreeNode root) {
        stack = new Stack<>(); // initialize the stack
        add(root); //add the current node and all its left child to the stack
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        add(node.right);
        return node.val;
    }

    /** @add the current node and all its left child to the stack*/
    private void add(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
