package com.whitespace.raghav.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 6/11/15.
 */
public class TreeTraversals {

    private static void inorder(Tree node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    private static void preorder(Tree node) {
        if (node == null)
            return;

        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    private static void postorder(Tree node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data);
    }
}
