package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q146_LRU_Cache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int len;

    public Q146_LRU_Cache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        len = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            removeNode(temp);
            insertHead(temp);

            return temp.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            // update the node
            temp.val = value;

            removeNode(temp);
            insertHead(temp);
            map.put(key, temp);

        } else { // do not contain
            Node temp = new Node(key, value);
            if (len < capacity) {
                len++;
            } else if (len == capacity) {
                map.remove(tail.key);
                removeTail();
            }
            insertHead(temp);
            map.put(key, temp);
        }
    }

    private void removeNode(Node node) {
        Node curNode = node;
        Node preNode = node.pre;
        Node nextNode = node.next;

        if (preNode == null) {
            head = head.next;
            if (head == null) tail = head;
            else head.pre = null;
        } else if (nextNode == null) {
            tail = tail.pre;
            if (tail == null) head = tail;
            else tail.next = null;
        } else {
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }
    }

    private void insertHead(Node node) {
        if (head == null) {
            head = node;
            tail = head;
            head.pre = null;
            tail.next = null;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
            head.pre = null;
        }
    }

    private void removeTail() {
        tail = tail.pre;
        if (tail == null) head = tail;
        else tail.next = null;
    }

    // Doubly linked list
    class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}


