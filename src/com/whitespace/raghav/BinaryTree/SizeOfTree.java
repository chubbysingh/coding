package com.whitespace.raghav.BinaryTree;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 7/29/15.
 */
public class SizeOfTree {
    public static int sizeRecursive(Tree node) {
        if (node == null)
            return 0;

        else
            return sizeRecursive(node.left) + 1 + sizeRecursive(node.right);
    }

    public static int sizeIterative(Tree node) {
        if (node == null)
            return 0;

        Stack<Tree> treeStack = new Stack<Tree>();
        treeStack.push(node);
        int size = 0;

        while (!treeStack.isEmpty()) {
            Tree curr = treeStack.pop();
            size++;
            if (curr.left != null)
                treeStack.push(curr.left);
            if (curr.right != null)
                treeStack.push(curr.right);

        }
        return size;

    }

    public static void main(String args[]) {
        Tree node = TreeUtils.populateTree();
        int sizeRecursive = sizeRecursive(node);
        int sizeIterative = sizeIterative(node);

        System.out.println("Recursive Size is : " + sizeRecursive);
        System.out.println("Iterative Size is : " + sizeIterative);
    }
}
