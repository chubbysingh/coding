package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode prev = newHead;
        ListNode curr = head;

        while (curr != null) {
            prev = newHead;
            ListNode next = curr.next;

            while (prev.next != null && prev.next.data < curr.data) {
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return newHead.next;
    }
}
