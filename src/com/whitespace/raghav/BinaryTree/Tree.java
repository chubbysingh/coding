package com.whitespace.raghav.BinaryTree;

/**
 * Created by rbhatnagar2 on 6/11/15.
 */
public class Tree {
    public String data;
    Tree left, right;

    public Tree(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "data='" + data + '\'' +
                '}';
    }
}
