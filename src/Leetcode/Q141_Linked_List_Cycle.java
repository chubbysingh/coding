package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode walker = head;
        ListNode runner = head;

        while (walker.next != null && runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner)
                return true;
        }
        return false;
    }
}
