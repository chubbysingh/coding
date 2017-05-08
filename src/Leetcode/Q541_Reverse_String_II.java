package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 */
public class Q541_Reverse_String_II {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
