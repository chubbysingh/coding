package com.whitespace.raghav.Stack;

/**
 * Created by rbhatnagar2 on 9/20/15.
 */
public class MyStackFromArray {
    private final int capacity;
    private int[] arr;
    private int top = -1;

    MyStackFromArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == capacity - 1);
    }

    public void push(int x) throws Exception {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        arr[++top] = x;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("dadada");
        }
        return arr[top--];
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("dadada");
        }
        return arr[top];
    }
}
