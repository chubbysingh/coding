package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q099_Recover_Binary_Search_Tree {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        // If first element has not been found, assign it to prevElement
        if (first == null && pre.val >= root.val) {
            first = pre;
        }

        // If first element is found, assign the second element to the root
        if (first != null && pre.val >= root.val) {
            second = root;
        }
        pre = root;

        traverse(root.right);
    }
}
