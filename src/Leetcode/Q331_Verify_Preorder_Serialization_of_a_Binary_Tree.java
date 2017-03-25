package Leetcode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q331_Verify_Preorder_Serialization_of_a_Binary_Tree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }

        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for (String node : nodes) {
            if (node.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }

                    stack.pop();
                }
            }

            stack.push(node);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}
