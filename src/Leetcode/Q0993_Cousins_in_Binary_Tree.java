package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * We are given the root of a binary tree with unique values,
 * and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 */

public class Q0993_Cousins_in_Binary_Tree {

    public boolean isCousins(TreeNode root, int A, int B) {
        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            boolean isAExists = false;
            boolean isBExists = false;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                if (curr.val == A) {
                    isAExists = true;
                }

                if (curr.val == B) {
                    isBExists = true;
                }

                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == A && curr.right.val == B)
                            || (curr.left.val == B && curr.right.val == A)) {
                        return false;
                    }
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            if (isAExists && isBExists) {
                return true;
            }
        }
        return false;
    }
}
