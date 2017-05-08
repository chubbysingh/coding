package com.whitespace.raghav.BinaryTree;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 6/15/15.
 */
public class InorderTraversal {

    public static void inOrderRecursive(Tree root) {
        if (root == null)
            return;

        inOrderRecursive(root.left);
        System.out.print(root.data + " ");
        inOrderRecursive(root.right);
    }

    public static void inOrderIterative(Tree root) {
        boolean done = false;
        if (root == null)
            return;

        Stack<Tree> stringStack = new Stack<Tree>();
        Tree current = root;

        while (!done) {
            while (current != null) {
                stringStack.push(current);
                current = current.left;
            }

            if (!stringStack.isEmpty()) {
                current = stringStack.pop();
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                done = true;
            }
        }
    }

    public static void inOrderIterativeTwo(Tree node) {
        if (node == null)
            return;

        Stack<Tree> treeStack = new Stack<Tree>();
        while (node != null) {
            treeStack.push(node);
            node = node.left;
        }

        while (!treeStack.isEmpty()) {
            Tree curr = treeStack.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    treeStack.push(curr);
                    curr = curr.left;
                }
            }
        }
    }


    public static void main(String[] args) {
        Tree root = TreeUtils.populateTree();

        inOrderRecursive(root);
        System.out.println("");
        inOrderIterative(root);
        System.out.println("");
        inOrderIterativeTwo(root);

    }
}
