package com.whitespace.raghav.LinkedList;

/**
 * Created by rbhatnagar2 on 5/20/16.
 */
public class SizeOfList {

    public static int getSizeIterative(Node head) {
        if (head == null) {
            return 0;
        }
        int size = 0;
        while (head.next != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static int getSizeRecursive(Node head) {
        if (head == null)
            return 0;

        return 1 + getSizeRecursive(head.next);
    }
}
