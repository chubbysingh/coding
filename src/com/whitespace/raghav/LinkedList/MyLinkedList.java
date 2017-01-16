package com.whitespace.raghav.LinkedList;

/**
 * Created by rbhatnagar2 on 5/18/16.
 */
public class MyLinkedList {

    private Node head;

    //Add a node at the front
    public void insertAtFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }
    //Add a node after a given node
    public void insertAfter(int data, Node prevNode) {
        Node newNode = new Node(data);

        if (prevNode == null)
            return;

        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    //Add a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    //Deleting a node
    public int deleteNode(int key) {
        if (head == null)
            return 0;

        Node currNode = head, prevNode = null;

        if (currNode.data == key) {
            head = currNode.next;
            return 1;
        }

        while (currNode != null && currNode.data != key) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (currNode == null) {
            return 0;
        }

        prevNode.next = currNode.next;
        return 1;
    }

}
