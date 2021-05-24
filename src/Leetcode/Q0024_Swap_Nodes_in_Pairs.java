package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 */
public class Q0024_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = new ListNode(1);
        ListNode result = curr;

        curr.next = head;

        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            first.next = second.next;
            second.next = first;
            curr.next = second;

            curr = curr.next.next;
        }

        return result.next;
    }
}
