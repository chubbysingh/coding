package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * https://leetcode.com/problems/partition-list/
 *
 */
public class Q086_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(1);
        ListNode bigger = new ListNode(1);

        smaller.next = head;
        ListNode smPointer = smaller.next;
        ListNode prev = smaller;

        ListNode bPointer = bigger;

        while(smPointer != null) {
            if (smPointer.data < x) {
                smPointer = smPointer.next;
                prev = prev.next;
            } else {
                bPointer.next = smPointer;
                prev.next = smPointer.next;
                smPointer = prev.next;

                bPointer = bPointer.next;
            }
        }
        bPointer.next = null;
        prev.next = bigger.next;
        return smaller.next;
    }
}
