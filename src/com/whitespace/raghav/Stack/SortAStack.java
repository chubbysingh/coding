package com.whitespace.raghav.Stack;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 10/16/15.
 */
public class SortAStack {
    private static void sort(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int pop = stack.pop();
        sort(stack);
        insertSorted(stack, pop);

    }

    private static void insertSorted(Stack<Integer> stack, int item) {
        if (stack.isEmpty())
            stack.push(item);
        else {
            int pop = stack.pop();
            if (pop < item) {
                stack.push(pop);
                stack.push(item);
            } else {
                insertSorted(stack, item);
                stack.push(pop);
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(32);
        stack.push(11);
        stack.push(50);
        stack.push(40);
        stack.push(15);
        stack.push(18);
        stack.push(3);
        stack.push(10);
        stack.push(1);

        System.out.println(stack);

        sort(stack);

        System.out.println(stack);
    }
}
