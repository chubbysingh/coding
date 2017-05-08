package com.whitespace.raghav.Arrays;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 9/20/15.
 */
public class NextGreaterElement {

    public static void nextGreaterElement(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];

            if (!stack.isEmpty()) {
                int element = stack.pop();

                while (element < next) {
                    System.out.println(element + "--->" + next);
                    if (stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();

                }
                if (element > next) {
                    stack.push(element);
                }

            }
            stack.push(next);
        }

        while (!stack.isEmpty()) {
            int element = stack.pop();
            System.out.println(element + "---> -1");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 2, 25};
        int[] arr2 = {3, 7, 6, 12};
        int[] arr3 = {16, 12, 11, 10, 14, 23, 15, 12, 18, 5, 17};
        nextGreaterElement(arr1);


    }
}
