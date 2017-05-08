package com.whitespace.raghav.Stack;

import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports
 * all the stack operations like push(), pop(), isEmpty(), isFull()
 * and an additional operation getMin() which should return minimum element from the SpecialStack.
 * All these operations of SpecialStack must be O(1).
 * <p>
 * Created by rbhatnagar2 on 9/20/15.
 */
public class SpecialStack extends MyStackFromArray {
    Stack<Integer> minStack = new Stack<Integer>();

    SpecialStack(int capacity) {
        super(capacity);
    }

    @Override
    public void push(int item) throws Exception {
        if (minStack.isEmpty()) {
            minStack.push(item);
        } else {
            int min = super.peek() > item ? item : super.peek();
            minStack.push(min);
        }
        super.push(item);
    }

    @Override
    public int pop() throws Exception {
        minStack.pop();
        return super.pop();
    }

    public int getMin() {
        return minStack.peek();
    }
}
