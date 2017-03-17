package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q061_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        //Boundry condition
        if(head == null) return head;

        //Calculate the length
        int length = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            length++;
        }

        // Adjust k if its more than k
        if (k >= length)
            k = k % length;

        // Split list to fpart and lpart
        ListNode lpart, fpart;
        lpart = head;
        for(int i = 1; i < length - k; i++){
            head = head.next;
        }

        fpart = head.next;
        head.next = null;

        // move to last element of fpart and assign next as lpart
        if(fpart == null) return lpart;
        node = fpart;
        while(node.next != null){
            node = node.next;
        }
        node.next = lpart;

        return fpart;
    }
}
