package com.whitespace.raghav.Stack;

/**
 * How to implement a stack which will support following operations in O(1) time complexity?
 * 1) push() which adds an element to the top of stack.
 * 2) pop() which removes an element from top of stack.
 * 3) findMiddle() which will return middle element of the stack.
 * 4) deleteMiddle() which will delete the middle element.
 * Push and pop are standard stack operations.
 * <p>
 * Created by rbhatnagar2 on 10/16/15.
 */
public class StackWithMiddle {
    private DLL head;
    private DLL mid;
    private int size;

    public void push(int x) {
        size++;
        if (head == null) {
            head = new DLL(x);
            mid = head;
        } else {
            DLL node = new DLL(x);
            node.right = head;
            head.left = node;
            head = node;
            if (size % 2 == 0) {
                mid = mid.right;
            }
        }
    }

    public int pop() {
        if (head == null)
            return -1;

        size--;
        int data = head.data;
        head = head.right;
        head.left = null;
        if (size % 2 == 0) {
            mid = mid.left;
        }
        return data;
    }

    public int findMiddle() {
        return mid.data;
    }

    public void deleteMid() {
        if (head == null)
            return;

        DLL temp;
        size--;
        if (size % 2 == 0)
            temp = mid.right;
        else
            temp = mid;

        if (mid.left != null)
            mid.left.right = mid.right;
        if (mid.right != null)
            mid.right.left = mid.left;
        mid = temp;
    }
}

class DLL {
    DLL left;
    int data;
    DLL right;

    DLL(int data) {
        this.data = data;
    }
}
