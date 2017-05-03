package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class Q142_Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        boolean hasCycle = false;

        ListNode walker = head;
        ListNode runner = head;

        while (walker.next != null && runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                hasCycle = true;
                break;
            }

        }
        // check if the list has no cycle
        if (!hasCycle)
            return null;

        // find the entrance of the cycle
        walker = head;
        while (walker != runner) {
            walker = walker.next;
            runner = runner.next;
        }
        return walker;
    }
}
