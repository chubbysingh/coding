package com.whitespace.raghav.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 7/30/15.
 */
public class LeafNodes {
    public static int countLeafNodesRecursive(Tree node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return countLeafNodesRecursive(node.left) + countLeafNodesRecursive(node.right);
    }

    public static int countLeafNodesIterative(Tree node) {
        if (node == null)
            return 0;

        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(node);

        int count = 0;

        while (!queue.isEmpty()) {
            Tree curr = queue.poll();
            if (curr.left == null && curr.right == null) {
                count++;
            } else {
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Tree nodeA = TreeUtils.populateTree();
        int countA = countLeafNodesRecursive(nodeA);
        int countB = countLeafNodesIterative(nodeA);
        System.out.println("Count of Leaf Nodes Recursive : " + countA);
        System.out.println("Count of Leaf Nodes Iterative: " + countB);
    }
}
