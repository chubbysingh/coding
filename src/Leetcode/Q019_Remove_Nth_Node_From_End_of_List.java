package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q019_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        //if remove the first node
        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
