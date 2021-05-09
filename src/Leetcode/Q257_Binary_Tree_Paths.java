package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class Q257_Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        findPaths(root, "", result);
        return result;
    }

    private void findPaths(TreeNode root, String paths, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(paths + root.val);
            return;
        }

        if (root.left != null) {
            findPaths(root.left, paths + root.val + "->", result);
        }

        if (root.right != null) {
            findPaths(root.right, paths + root.val + "->", result);
        }
    }
}
