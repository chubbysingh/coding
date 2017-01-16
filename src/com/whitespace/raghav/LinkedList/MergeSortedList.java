package com.whitespace.raghav.LinkedList;

/**
 * Created by rbhatnagar2 on 12/13/15.
 */
public class MergeSortedList {
    public Node merge(Node a, Node b) {
        if (a == null && b == null)
            return null;
        if (a == null || b == null)
            return a == null ? b : a;

        Node result = new Node(0);
        Node currNode = result;

        while (a != null && b != null) {
            if (a.data < b.data) {
                currNode.next = a;
                a = a.next;
            } else {
                currNode.next = b;
                b = b.next;
            }
        }

        if (a != null) {
            currNode.next = a;
        }
        if (b != null) {
            currNode.next = b;
        }
        result = result.next;
        return result;
    }
}
