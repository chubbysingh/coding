package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 */
public class Q092_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        int count = 1;
        /// Find the tail node of the first segment
        ListNode firstTail = dummyNode;
        while (count < m) {
            firstTail = firstTail.next;
            count++;
        }

        /// reverse the middle segement
        ListNode midTail = firstTail.next;
        ListNode midHead = firstTail.next;

        ListNode prev = null;
        int num = n - m + 1;
        int i = 0;
        while (i < num) {
            ListNode next = midHead.next;
            midHead.next = prev;
            prev = midHead;
            midHead = next;
            i++;
        }

        /// Link with the third segment
        firstTail.next = prev;
        midTail.next = midHead;

        return dummyNode.next;

    }
}
