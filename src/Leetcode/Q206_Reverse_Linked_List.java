package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class Q206_Reverse_Linked_List {

    // Iterative
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode secondElem = head.next;
        head.next = null;

        ListNode rev = reverseList(secondElem);
        rev = join(rev, head);

        return rev;
    }

    private static ListNode join(ListNode first, ListNode second) {
        if (first == null && second == null)
            return null;
        else if (first == null || second == null)
            return first == null ? second : first;
        else {
            ListNode head = first;
            while (first.next != null) {
                first = first.next;
            }
            first.next = second;
            return head;
        }
    }

    // Recursive
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
