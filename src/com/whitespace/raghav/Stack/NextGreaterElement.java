package com.whitespace.raghav.Stack;

import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element
 * on the right side of x in array.
 * Elements for which no greater element exist, consider next greater element as -1.
 * Created by rbhatnagar2 on 10/16/15.
 */
public class NextGreaterElement {
    private static void nextGreaterElement(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];

            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (element > pop) {
                    System.out.println(pop + " -> " + element);
                } else {
                    stack.push(pop);
                    break;
                }
            }
            stack.push(element);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " -> -1");
        }
    }

    public static void main(String[] args) {
        int arr[] = {40};
        nextGreaterElement(arr);
    }
}
