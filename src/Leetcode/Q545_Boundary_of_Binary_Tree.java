package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 5/3/17.
 * <p>
 * Given a binary tree, return the values of its boundary
 * in anti-clockwise direction starting from root.
 * Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 * <p>
 * Left boundary is defined as the path from root to the left-most node.
 * Right boundary is defined as the path from root to the right-most node.
 * If the root doesn't have left subtree or right subtree,
 * then the root itself is left boundary or right boundary.
 * <p>
 * Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * <p>
 * The left-most node is defined as a leaf node you could reach
 * when you always firstly travel to the left subtree if exists.
 * If not, travel to the right subtree. Repeat until you reach a leaf node.
 * <p>
 * The right-most node is also defined by the same way with left and right exchanged.
 */

public class Q545_Boundary_of_Binary_Tree {
    List<Integer> nodes = new ArrayList<Integer>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if (root == null) return nodes;

        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return nodes;
    }

    public void leftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        nodes.add(root.val);
        if (root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }

    public void rightBoundary(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return;
        if (root.right == null) rightBoundary(root.left);
        else rightBoundary(root.right);
        nodes.add(root.val); // add after child visit(reverse)
    }

    public void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}
