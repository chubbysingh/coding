package com.whitespace.raghav.Stack;

import java.util.NoSuchElementException;

/**
 * Created by rbhatnagar2 on 10/20/15.
 */
public class MyStackFromLinkedList {
    MyLinkedList head;

    public void push(int item) {
        if (head == null) {
            head = new MyLinkedList(item);
        } else {
            MyLinkedList node = new MyLinkedList(item);
            node.next = head;
            head = node;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        int data = head.data;
        head = head.next;
        return data;
    }
}

class MyLinkedList {
    int data;
    MyLinkedList next;

    MyLinkedList(int data) {
        this.data = data;
    }
}
