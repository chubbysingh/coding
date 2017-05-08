package com.whitespace.raghav.LinkedList;

/**
 * Created by rbhatnagar2 on 12/10/15.
 * <p>
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public Node sumIterative(Node a, Node b) {
        Node result = null;
        Node currNode = null;
        int carry = 0;

        while (a != null || b != null) {
            int sum = carry;
            if (a != null) {
                sum += a.data;
                a = a.next;
            }
            if (b != null) {
                sum += b.data;
                b = b.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            Node sumNode = new Node(sum);
            if (result == null) {
                result = sumNode;
                currNode = sumNode;
            } else {
                currNode.next = sumNode;
            }

        }
        if (carry != 0) {
            Node carryNode = new Node(carry);
            currNode.next = carryNode;
        }
        return result;
    }


}
