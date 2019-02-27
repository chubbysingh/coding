package Leetcode;

import Leetcode.Util.TreeNode;
import java.util.LinkedList;
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
        List<String> result = new LinkedList<String>();
        if (root == null)
            return result;
        searchBT(root, "", result);
        return result;
    }
    private void searchBT(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
            return;
        }

        if (root.left != null)
            searchBT(root.left, path + root.val + "->", result);
        if (root.right != null)
            searchBT(root.right, path + root.val + "->", result);
    }
}
