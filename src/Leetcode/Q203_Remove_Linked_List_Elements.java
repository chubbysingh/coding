package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;

        while(head != null && head.data == val) {
            head = head.next;
        }

        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr.next.data == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
