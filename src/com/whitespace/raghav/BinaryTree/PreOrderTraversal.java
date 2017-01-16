package com.whitespace.raghav.BinaryTree;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 7/29/15.
 */
public class PreOrderTraversal {

    public static void preOrderRecursive(Tree node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrderRecursive(node.left);
        preOrderRecursive(node.right);
    }

    public static void preOrderIterative(Tree node) {
        if (node == null)
            return;

        Stack<Tree> treeStack = new Stack<Tree>();
        while (node != null) {
            System.out.print(node.data + " ");
            treeStack.push(node);
            node = node.left;
        }


        while (!treeStack.isEmpty()) {
            Tree curr = treeStack.pop();
            curr = curr.right;
            while (curr != null) {
                System.out.print(curr.data + " ");
                treeStack.push(curr);
                curr = curr.left;
            }
        }
    }

    public static void main(String[] args) {
        Tree node = TreeUtils.populateTree();
        preOrderRecursive(node);
        System.out.println("");
        //preOrderIterative(node);
    }
}
