package com.whitespace.raghav.BinaryTree;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 7/30/15.
 */
public class ThreadedBinaryTree {
    String data;
    ThreadedBinaryTree left;
    ThreadedBinaryTree right;
    boolean isRightThreaded;

    public class inorderThreadedBinaryThree{
        public void inorder(ThreadedBinaryTree root) {
            ThreadedBinaryTree curr = getLeftMostNode(root);

            while (curr != null) {
                System.out.println(curr.data);
                if (curr.isRightThreaded) {
                    curr = curr.right;
                } else {
                    curr = getLeftMostNode(curr.right);
                }

            }
        }

        private ThreadedBinaryTree getLeftMostNode(ThreadedBinaryTree root) {
            while (root != null) {
                root = root.left;
            }
            return root;
        }
    }
}


