package com.whitespace.raghav.Stack;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 9/20/15.
 */
public class ReverseStack {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int pop = stack.pop(); //pop 4
        reverse(stack); // stack becomes [1, 2, 3

        insertAtBottom(stack, pop); // stack becomes [1, 2, 3, 4
    }

    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            int pop = stack.pop();
            insertAtBottom(stack, item);
            stack.push(pop);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // I/p Stack - > [1, 2, 3, 4
        System.out.println(stack);

        reverse(stack);

        // O/p Stack - > [4, 3, 2, 1
        System.out.println(stack);

    }
}
