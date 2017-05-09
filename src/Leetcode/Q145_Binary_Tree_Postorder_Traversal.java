package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);
        TreeNode prev = null;

        while (!stack.empty()) {
            TreeNode curr = stack.peek();
            if (prev == null || curr == prev.left || curr == prev.right) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    result.add(curr.val);
                }
            } else if (prev == curr.left) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    result.add(curr.val);
                }
            } else if (prev == curr.right) {
                stack.pop();
                result.add(curr.val);
            }

            prev = curr;
        }

        return result;
    }
}
