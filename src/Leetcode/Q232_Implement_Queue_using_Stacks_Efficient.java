package Leetcode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Complexity:
 *  push: O(1)
 *  pop: O(1) : Amortized ; O(n) : Worst Case
 *  peek: O(1) : Amortized ; O(n) : Worst Case
 *  isEmpty: O(1)
 */
public class Q232_Implement_Queue_using_Stacks_Efficient {
    Stack<Integer> pushStack = new Stack<Integer>();
    Stack<Integer> popStack = new Stack<Integer>();

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (popStack.isEmpty()) {
            return popStack.pop();
        }

        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (popStack.isEmpty()) {
            return popStack.peek();
        }

        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
