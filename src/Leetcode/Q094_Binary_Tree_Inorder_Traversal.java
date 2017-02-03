package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;

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
}
