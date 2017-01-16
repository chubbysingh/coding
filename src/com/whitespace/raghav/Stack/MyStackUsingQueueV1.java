package com.whitespace.raghav.Stack;

import java.util.NoSuchElementException;

/**
 * Making push operation expensive
 * Created by rbhatnagar2 on 10/20/15.
 */
public class MyStackUsingQueueV1 {
    MyQueue storage;
    MyQueue cache;

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public void push(int item) {
        if (isEmpty())
            storage.enqueue(item);
        else {
            if (storage.size() > 0) {
                cache.enqueue(item);
                while(!storage.isEmpty()) {
                    cache.enqueue(storage.dequeue());

                    MyQueue temp;
                    temp = storage;
                    storage = cache;
                    cache = temp;
                }
            }
        }
    }

    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException("dadada");
        return storage.dequeue();
    }
}

abstract class MyQueue {
    public abstract void enqueue(int item);
    public abstract int dequeue();
    public abstract boolean isEmpty();
    public abstract int size();
}
