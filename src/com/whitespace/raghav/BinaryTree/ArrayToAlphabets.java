package com.whitespace.raghav.BinaryTree;

/**
 * Created by rbhatnagar2 on 10/12/15.
 * Find all possible interpretations of an array of digits
 * <p>
 * Consider a coding system for alphabets to integers
 * where ‘a’ is represented as 1, ‘b’ as 2, .. ‘z’ as 26.
 * Given an array of digits (1 to 9) as input,
 * write a function that prints all valid interpretations of input array.
 */
public class ArrayToAlphabets {
    private static final char alphabets[] =
            {
                    'A', 'B', 'C',
                    'D', 'E', 'F',
                    'G', 'H', 'I',
                    'J', 'K', 'L',
                    'M', 'N', 'O',
                    'P', 'Q', 'R',
                    'S', 'T', 'U',
                    'V', 'W', 'X',
                    'Y', 'Z'
            };

    private static void printLeafNodes(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            System.out.println(root.data);

        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    private static Node createTree(String s, int[] arr, int index) {

        Node root = new Node(s);

        if (index >= arr.length)
            return root;

        int data = arr[index];
        String newString = null;
        if (data > 0) {
            newString = s + alphabets[data - 1];
            root.left = createTree(newString, arr, index + 1);
        }

        if (index + 1 < arr.length) {
            data = arr[index] * 10 + arr[index + 1];
            if (data > 0 && data <= 26) {
                newString = s + alphabets[data - 1];
                root.right = createTree(newString, arr, index + 2);
            }
        }
        return root;
    }

    private static void printArrayToAlphabet(int[] arr) {
        Node root = createTree("", arr, 0);
        printLeafNodes(root);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 3, 4};
        //printArrayToAlphabet(arr1);

        int[] arr2 = {1, 1, 1};
        printArrayToAlphabet(arr2);

        int[] arr3 = {2, 6};
        //printArrayToAlphabet(arr3);

        int[] arr4 = {1, 2};
        //printArrayToAlphabet(arr4);

        int[] arr5 = {1, 0};
        //printArrayToAlphabet(arr5);

        int[] arr6 = {};
        //printArrayToAlphabet(arr6);

        int[] arr7 = {1, 2, 2, 1};
        //printArrayToAlphabet(arr7);

    }

}

class Node {
    String data;
    Node left, right;

    public Node(String data) {
        this.data = data;
    }
}
