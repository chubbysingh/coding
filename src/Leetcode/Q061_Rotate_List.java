package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q061_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        //Boundry condition
        if (head == null) return head;

        //Calculate the length
        int length = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            length++;
        }

        //Convert it into cyclic linkedList
        node.next = head;

        // Adjust k if its more than k
        if (k >= length)
            k = k % length;

        // Move head to length-k-1 steps (supposedly last element of the list)
        for (int i = 0; i < length - k - 1; i++)
            head = head.next;

        //Next item should be the head of new list
        node = head.next;

        //Disconnect the cycle
        head.next = null;

        //Return the new head
        return node;
    }
}
