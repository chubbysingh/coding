package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q080_Remove_Duplicates_from_Sorted_Array_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode curr = head;

        while(curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
