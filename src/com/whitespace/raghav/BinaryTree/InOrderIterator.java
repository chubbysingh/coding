package com.whitespace.raghav.BinaryTree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 10/16/15.
 */
public class InOrderIterator implements Iterator<Node> {
    Stack<Node> stack = new Stack<Node>();

    InOrderIterator(Node root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
        Node curr = stack.pop();
        if (curr.right != null) {
            curr = curr.right;
            while (curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
            }
        }
        return curr;
    }

    @Override
    public void remove() {
        try {
            throw new Exception("Unsupported Operation");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
