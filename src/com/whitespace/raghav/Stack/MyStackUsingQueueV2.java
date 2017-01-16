package com.whitespace.raghav.Stack;

import java.util.NoSuchElementException;

/**
 * Making pop operation expensive
 * Created by rbhatnagar2 on 10/21/15.
 */
public class MyStackUsingQueueV2 {
    MyQueue storage;
    MyQueue cache;

    public boolean isEmpty() {
        return storage == null;
    }

    public void push(int item) {
        storage.enqueue(item);
    }

    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException("dadada");
        else {
            int curr = -1;
            while (!storage.isEmpty()) {
                curr = storage.dequeue();
                if (!storage.isEmpty()) {
                    cache.enqueue(curr);
                }
            }

            MyQueue temp;
            temp = storage;
            storage = cache;
            cache = temp;
            return curr;
        }


    }
}