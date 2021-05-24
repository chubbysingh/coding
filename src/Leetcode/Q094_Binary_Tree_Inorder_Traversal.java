package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q094_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new LinkedList<Integer>();
        return inorderTraversal(root, resultList);
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> resultList) {
        if (root == null)
            return resultList;

        inorderTraversal(root.left, resultList);
        resultList.add(root.val);
        inorderTraversal(root.right, resultList);

        return resultList;
    }


    /* Iterative */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode curr = root;
        while (!stack.empty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                curr = temp.right;
            }
        }
        return result;
    }
}
