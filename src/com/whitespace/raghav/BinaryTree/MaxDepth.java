package com.whitespace.raghav.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 7/29/15.
 */
public class MaxDepth {
    public static int maxDepthRecursive(Tree node) {
        if (node == null)
            return 0;

        int lDepth = 1 + maxDepthRecursive(node.left);
        int rDepth = 1 + maxDepthRecursive(node.right);

        return lDepth > rDepth ? lDepth : rDepth;
    }


    public static int maxDepthIterative(Tree node) {
        if (node == null)
            return 0;

        Queue<Tree> queue = new LinkedList<Tree>();

        queue.add(node);
        queue.add(null);

        int depth = 0;

        while (!queue.isEmpty()) {
            Tree curr = queue.poll();

            if (curr == null) {
                depth++;
                if (!queue.isEmpty()) queue.add(null);
            } else {
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
        return depth;

    }

    // Buggy!!
    public static int maxDepthIterativeTwo(Tree node) {
        if (node == null)
            return 0;

        Stack<Tree> stack = new Stack<Tree>();
        Stack<Integer> level = new Stack<Integer>();

        stack.push(node);
        level.push(1);

        while (!stack.isEmpty()) {
            Tree curr = stack.pop();
            int depth = level.pop();

            if (curr.left != null)
                stack.push(curr.left);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null || curr.right != null)
                level.push(depth + 1);
        }
        return level.pop();

    }

    public static void main(String[] args) {

        Tree node = TreeUtils.populateTree();
        int maxDepthRecursive = maxDepthRecursive(node);
        int maxDepthIterative = maxDepthIterative(node);
        //int maxDepthIterativeTwo = maxDepthIterativeTwo(node);

        System.out.println("Max Depth Recursive : " + maxDepthRecursive);
        System.out.println("Max Depth Iterative : " + maxDepthIterative);
        //System.out.println("Max Depth Iterative Two: " + maxDepthIterativeTwo);


    }
}
