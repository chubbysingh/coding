package com.whitespace.raghav.LinkedList;

/**
 * Created by rbhatnagar2 on 9/14/15.
 */
public class Reverse {
    private static Node reverse(Node list) {
        //Reverse of null is null
        if (list == null) {
            return null;
        }
        //Reverse of a single element is the element
        if (list.next == null) {
            return list;
        }
        // Reverse is reverse from 2nd element + first element
        Node secondElement = list.next;
        list.next = null;
        Node reverse = reverse(secondElement);
        reverse = join(reverse, list);

        return reverse;
    }

    private static Node reverseIterative(Node list) {
        if (list == null || list.next == null)
            return list;

        Node prevNode = null, nextNode = null;
        Node currNode = list;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;

    }

    private static Node join(Node first, Node second) {
        if (first == null && second == null)
            return null;
        else if (first == null || second == null)
            return first == null ? second : first;
        else {
            Node head = first;
            while (first.next != null) {
                first = first.next;
            }
            first.next = second;
            return head;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;

        Node n3 = new Node(3);
        n2.next = n3;

        Node n4 = new Node(4);
        n3.next = n4;

        Node n5 = new Node(5);
        n4.next = n5;

        Node n6 = new Node(6);
        n5.next = n6;

        Node reverse = reverseIterative(n1);

        printList(reverse);
    }

    private static void printList(Node node) {
        if (node == null)
            return;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }
}
