package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q143_Reorder_List {
    public void reorderList(ListNode head) {
        if (head  == null || head.next == null || head.next.next == null) return;

        // STEP 1: Find the middle point of the linked list, use fast-slow pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null; //truncate the first half

        // STEP 2: Reverse the second list
        ListNode prev = secondHead;
        ListNode curr = secondHead.next;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // setup the new head
        secondHead.next = null;
        secondHead = prev;


        // STEP 3: Merge the two lists together
        ListNode p1 = head;
        ListNode p2 = secondHead;

        while (p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
        if (p1 != null) p1.next = null; //tail pointer
    }
}
