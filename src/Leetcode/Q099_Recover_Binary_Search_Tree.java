package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q099_Recover_Binary_Search_Tree {
    TreeNode first;
    TreeNode second;
    TreeNode pre;

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (pre == null) {
            pre = root;
        } else {
            if (root.val < pre.val) {
                if (first == null) {
                    first = pre;
                }

                second = root;
            }
            pre = root;
        }

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        inorder(root);
        if (second != null && first != null) {
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }

    }
}
