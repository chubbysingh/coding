package com.whitespace.raghav.BinaryTree;

/**
 * Created by rbhatnagar2 on 7/30/15.
 */
public class PostOrderTraversal {
    public static void postOrderRecursive(Tree root) {
        if (root == null)
            return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Tree root = TreeUtils.populateTree();
        postOrderRecursive(root);
    }
}
