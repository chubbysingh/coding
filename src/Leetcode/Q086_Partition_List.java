package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * https://leetcode.com/problems/partition-list/
 */
public class Q086_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(1);
        ListNode bigger = new ListNode(1);

        ListNode sPointer = smaller;
        ListNode bPointer = bigger;

        while (head != null) {
            if (head.data < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        bigger.next = null;

        smaller.next = bPointer.next;
        return sPointer.next;
    }
}
