package Leetcode;

/**
 * Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.
 *
 * Return that integer.
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 */
public class Q1287_Element_Appearing_More_Than_25_pc_In_Sorted_Array {

    // Solution 1
    // Complexity: O(log(n))
    public int findSpecialInteger(int[] arr) {
        int targetCount = (int) arr.length / 4;

        for (int i = 0; i < arr.length; i++) {
            int borderStart = i;
            int borderEnd = findBorderEnd(arr, arr[i], 0, arr.length - 1);
            if (borderEnd - borderStart + 1 > targetCount)
                return arr[i];
            else
                i = borderEnd + 1;
        }
        return -1;
    }

    // Solution 2
    // Complexity: O(n)
    public int findSpecialInteger2(int[] arr) {
        if(arr.length == 1)
            return arr[0];
        int percent = arr.length / 4;
        int index = 0;
        int count = 1;
        while (index < arr.length-1) {
            if (arr[index] == arr[index + 1]) {
                count++;
                if (count > percent)
                    return arr[index];
                index++;
            }else {
                count = 1; index++;
            }
        }
        return 0;
    }

    private int findBorderEnd(int[] arr, int element, int start, int end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] == element) {
            if (mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
                return findBorderEnd(arr, element, mid + 1, end);
            }
        } else if (arr[mid] < element) {
            return findBorderEnd(arr, element, mid + 1, end);
        } else {
            return findBorderEnd(arr, element, start, mid - 1);
        }
        return mid;
    }

    public static void main(String[] args) {
        Q1287_Element_Appearing_More_Than_25_pc_In_Sorted_Array sol = new Q1287_Element_Appearing_More_Than_25_pc_In_Sorted_Array();

        int[] arr =   { 1,2,2,6,6,6,6,7,10 };

        int result = sol.findSpecialInteger(arr);
        System.out.println(result);
    }
}
