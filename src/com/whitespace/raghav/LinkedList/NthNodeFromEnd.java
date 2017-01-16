package com.whitespace.raghav.LinkedList;

/**
 * Created by rbhatnagar2 on 12/10/15.
 */
public class NthNodeFromEnd {

    public static Node getNthNode(Node head, int n) {
        Node curr = head;
        Node result = head;

        int len = 0;

        while (len < n && curr.next != null) {
            curr = curr.next;
            len++;
        }

        if (len < n) {
            return null;
        }

        while (curr.next != null) {
            curr = curr.next;
            result = result.next;
        }
        return result;
    }
}
