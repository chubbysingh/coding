package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
