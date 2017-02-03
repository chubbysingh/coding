package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 */
public class Q021_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode resHead = res;

        while(l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.data : Integer.MAX_VALUE;
            int val2 = l2 != null ? l2.data : Integer.MAX_VALUE;

            if (val1 < val2) {
                res.next = new ListNode(val1);
                l1 = l1.next;
            } else {
                res.next = new ListNode(val2);
                l2 = l2.next;
            }
            res = res.next;
        }
        return resHead.next;
    }
}
