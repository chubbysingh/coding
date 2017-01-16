package com.whitespace.raghav.BinaryTree;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 6/16/15.
 */
public class MaxMinInBTree {

    public static void main(String[] args) {
        BTree root = populateTree();

        System.out.println("Max Value : " + maximumValue(root));
        System.out.println("Min Value : " + minimumValue(root));
    }

    public static int maximumValue(BTree root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int rootData = root.data;
        int leftData = maximumValue(root.left);
        int rightData = maximumValue(root.right);

        return max(rootData, max(leftData, rightData));
    }

    public static int minimumValue(BTree root) {
        if (root == null)
            return Integer.MAX_VALUE;

        Stack<BTree> stack = new Stack<BTree>();
        int minValue = root.data;
        stack.push(root);
        while (!stack.isEmpty()) {
            BTree poppedTree = stack.pop();
            minValue = min(minValue, poppedTree.data);
            if (poppedTree.left != null) {
                stack.push(poppedTree.left);
            }
            if (poppedTree.right != null) {
                stack.push(poppedTree.right);
            }
        }
        return minValue;

    }

    public static int max(int a , int b) {
        return a > b ? a : b ;
    }

    public static int min(int a, int b) {
        return a < b ? a : b ;
    }

    public static BTree populateTree() {
        BTree n1 = new BTree(2);
        BTree n2 = new BTree(7);
        BTree n3 = new BTree(5);
        BTree n4 = new BTree(6);
        BTree n5 = new BTree(9);
        BTree n6 = new BTree(1);
        BTree n7 = new BTree(11);
        BTree n8 = new BTree(4);

        n1.left = n2;
        n1.right = n3;

        n2.right = n4;

        n4.left = n6;
        n4.right = n7;

        n3.right = n5;
        n5.left = n8;

        return n1;
    }

}

class BTree {
    int data;
    BTree left;
    BTree right;

    BTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
