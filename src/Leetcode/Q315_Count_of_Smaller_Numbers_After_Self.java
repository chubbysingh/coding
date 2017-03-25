package Leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q315_Count_of_Smaller_Numbers_After_Self {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];

        BSTNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], i, result, 0);
        }

        return Arrays.asList(result);
    }

    private BSTNode insert(BSTNode root, int num, int i, Integer[] result,
                           int preSum) {
        if (root == null) {
            root = new BSTNode(num, 0);
            result[i] = preSum;
            return root;
        } else if (root.val == num) {
            root.dup++;
            result[i] = preSum + root.numOfLeftNodes;
            return root;
        } else if (root.val > num) {
            root.numOfLeftNodes++;
            root.left = insert(root.left, num, i, result, preSum);
        } else {
            root.right = insert(root.right, num, i, result,
                    preSum + root.numOfLeftNodes + root.dup);
        }

        return root;
    }


}

class BSTNode {
    int val;
    int dup = 1;
    int numOfLeftNodes;
    BSTNode left, right;

    BSTNode(int val, int numOfLeftNodes) {
        this.val = val;
        this.numOfLeftNodes = numOfLeftNodes;
    }
}
