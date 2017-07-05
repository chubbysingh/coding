package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q031_Next_Permutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }

        int i, j;
        for (i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                break;
            }
        }

        // for the case where the num[] is in descending order
        if(i == -1) {
            reverse(num, 0);
            return;
        }

        for (j = i + 1; j < num.length; j++) {
            if (num[j] <= num[i]) {
                break;
            }
        }
        j = j - 1;
        swap(num, i, j);
        reverse(num, i + 1);
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverse(int[] num, int start) {
        int end = num.length - 1;
        while (start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;

            start++;
            end--;
        }
    }
}
