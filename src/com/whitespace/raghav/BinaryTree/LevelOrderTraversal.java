package com.whitespace.raghav.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 7/30/15.
 */
public class LevelOrderTraversal {

    //First method
    public static void levelOrderIterative(Tree root) {
        if (root == null)
            return;

        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree curr = queue.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    //Second method
    public static void levelOrderRecursive(Tree node) {
        if (node == null)
            return;

        int height = heightOfTree(node);

        for (int i = 0 ; i < height; i++) {
            printLevelOrderRecursive(node, i);
        }
    }

    private static int heightOfTree(Tree node) {
        if (node == null)
            return 0;
        return 1 + max(heightOfTree(node.left), heightOfTree(node.right));
    }

    private static int max(int i, int i1) {
        return i > i1 ? i : i1;
    }

    private static void printLevelOrderRecursive(Tree node, int level) {
        if (node == null)
            return;
        if (level == 0)
            System.out.print(node.data + " ");
        else {
            printLevelOrderRecursive(node.left, level-1);
            printLevelOrderRecursive(node.right, level-1);
        }
    }


    // Test
    public static void main(String[] args) {
        Tree nodeA = TreeUtils.populateTree();
        levelOrderIterative(nodeA);
        System.out.println("");
        levelOrderRecursive(nodeA);
    }
}
