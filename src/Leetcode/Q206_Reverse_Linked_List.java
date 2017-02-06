package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q206_Reverse_Linked_List {
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
}
