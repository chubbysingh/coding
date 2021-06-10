package Leetcode;

import java.util.Stack;

public class Q426_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node first = null;
        Node last = null;

        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                Node curr = stack.pop();

                //Logic start
                if (first == null) {
                    first = curr;
                }
                if (last != null) {
                    last.right = curr;
                    curr.left = last;
                }
                last = curr;
                //Logic end

                root = curr.right;
            }

        }
        first.left = last;
        last.right = first;
        return first;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
