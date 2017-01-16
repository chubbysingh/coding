package com.whitespace.raghav.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 7/30/15.
 */
public class MirrorOfTree {
    public static void mirrorRecursive(Tree root) {
        if (root == null)
            return;

        mirrorRecursive(root.left);
        mirrorRecursive(root.right);

        Tree temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void mirrorIterative(Tree root) {
        if (root == null)
            return;

        // can use stack as well
        //Basic idea is to iterate to every node in the tree
        // and swap its children
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree curr = queue.poll();

            //Swap left and right children
            Tree temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            //Add left and right children
            if (curr.left != null)
                queue.add(curr.left);

            if (curr.right != null)
                queue.add(curr.right);

        }

    }

    public static void main(String[] args) {
        Tree root = TreeUtils.populateTree();
        mirrorRecursive(root);
    }
}
