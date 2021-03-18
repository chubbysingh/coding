package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 */
public class Q0025_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode helper = new ListNode(0);
        helper.next = head;

        ListNode pre = helper;
        ListNode cur = head;

        int counter = 0;

        while (cur != null) {
            counter++;

            if (counter % k == 0) {
                pre = reverseRange(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }

        return helper.next;
    }

    // Reverse the linked list from pre to end, exclusively
    private ListNode reverseRange(ListNode prev, ListNode end) {
        ListNode head = prev.next;
        ListNode curr = head.next;

        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev.next;
            prev.next = curr;

            curr = temp;
        }

        head.next = end;
        return head;
    }
}
