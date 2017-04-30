package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q082_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                while (curr.next != null && curr.data == curr.next.data) {
                    curr = curr.next;
                }

                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }

        return dummyNode.next;
    }
}
