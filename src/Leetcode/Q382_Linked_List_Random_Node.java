package Leetcode;

import Leetcode.Util.ListNode;

import java.util.Random;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q382_Linked_List_Random_Node {
    ListNode node;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Q382_Linked_List_Random_Node(ListNode head) {
        node = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode ans = node;
        int val = ans.data;
        Random r = new Random();
        for (int i = 1; ans != null; i++) {
            if (r.nextInt(i) == 0) {
                val = ans.data;
            }
            ans = ans.next;
        }
        return val;
    }
}
