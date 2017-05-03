package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
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
            second.next = first;

            curr = curr.next.next;
        }
        return dummy.next;

    }
}
