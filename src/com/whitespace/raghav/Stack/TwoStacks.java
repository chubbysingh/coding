package com.whitespace.raghav.Stack;

/**
 * Implement two stacks in an array
 * Created by rbhatnagar2 on 10/16/15.
 */
public class TwoStacks {
    private final int[] arr;
    private final int combinedCapacity;
    private int top1;
    private int top2;

    TwoStacks(int combinedCapacity) {
        this.combinedCapacity = combinedCapacity;
        arr = new int[combinedCapacity];
        top1 = -1;
        top2 = combinedCapacity;
    }

    public boolean isFull() {
        return top1 == top2-1;
    }

    public boolean isStack1Empty() {
        return top1 == -1;
    }

    public boolean isStack2Empty() {
        return top2 == combinedCapacity;
    }

    public void push1(int x) {
        if (!isFull()) {
            arr[++top1] = x;
        } else {
            System.out.println("Overflow");
        }
    }

    public void push2(int x) {
        if (!isFull()) {
            arr[--top2] = x;
        } else {
            System.out.println("Overflow");
        }
    }

    public int pop1() {
        if (isStack1Empty()) {
            System.out.println("Stack1 is empty");
            return -1;
        } else {
            return arr[top1--];
        }
    }

    public int pop2() {
        if (isStack2Empty()) {
            System.out.println("Stack2 is empty");
            return -1;
        }
        return arr[top2++];
    }
}
