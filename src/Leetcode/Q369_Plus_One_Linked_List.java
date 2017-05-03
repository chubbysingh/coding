package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a non-negative number represented as a singly linked list of digits,
 * plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1->2->3
 * <p>
 * Output:
 * 1->2->4
 */

public class Q369_Plus_One_Linked_List {
    public ListNode plusOne(ListNode head) {
        ListNode h2 = reverse(head);

        ListNode p = h2;

        while (p != null) {
            if (p.data + 1 <= 9) {
                p.data = p.data + 1;
                break;
            } else {
                p.data = 0;
                if (p.next == null) {
                    p.next = new ListNode(1);
                    break;
                }
                p = p.next;
            }
        }

        return reverse(h2);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;
        while (p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        head.next = null;

        return p1;
    }
}
