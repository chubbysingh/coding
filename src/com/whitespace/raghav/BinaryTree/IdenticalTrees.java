package com.whitespace.raghav.BinaryTree;

/**
 * Created by rbhatnagar2 on 7/30/15.
 */
public class IdenticalTrees {

    private static boolean isIdenticalRecursive(Tree nodeA, Tree nodeB) {
        if (nodeA == null && nodeB == null)
            return true;
        if (nodeA == null || nodeB == null)
            return false;
        return (nodeA.data == nodeB.data
                && isIdenticalRecursive(nodeA.left, nodeB.left)
                && isIdenticalRecursive(nodeA.right, nodeB.right));
    }

    public static void main(String[] args) {
        Tree nodeA = TreeUtils.populateTree();
        Tree nodeB = TreeUtils.populateTree();
        boolean isIdentical = isIdenticalRecursive(nodeA, nodeB);
        System.out.println(isIdentical);
    }
}
