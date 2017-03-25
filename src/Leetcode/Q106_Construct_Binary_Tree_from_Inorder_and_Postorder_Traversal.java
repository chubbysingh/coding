package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;

        int len = inorder.length;
        return buildTree(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd) return null;

        int rootVal = postorder[poEnd];
        int rootIdx = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int len = rootIdx - inStart;

        root.left = buildTree(inorder, inStart, rootIdx - 1, postorder, poStart, poStart + len - 1);
        root.right = buildTree(inorder, rootIdx + 1, inEnd, postorder, poStart + len, poEnd - 1);

        return root;
    }
}
