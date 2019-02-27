package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 *
 * Example 1:
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 *
 * Note:
 *
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 */
public class Q237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
