package Leetcode;

import Leetcode.Util.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
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
