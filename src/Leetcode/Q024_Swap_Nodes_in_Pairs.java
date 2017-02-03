package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 */
public class Q024_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            first.next = second.next;
            curr.next = second;
            curr.next.next = first;

            curr = curr.next.next;
        }
        return dummy.next;

    }
}
