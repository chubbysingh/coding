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

    // Solution 2
    // Complexity: O(n)
    public int findSpecialInteger2(int[] arr) {
        if(arr.length == 1)
            return arr[0];

        int percent = arr.length / 4;
        int count = 1;

        for (int i=0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i+1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > percent) {
                return arr[i];
            }
        }

        return 0;
    }

    // Solution 1
    // Complexity: O(log(n))
    public int findSpecialInteger(int[] arr) {
        int targetCount = arr.length / 4;

        //If the element occurs more than 25%, it will be available in
        // either position n/4, n/2, 3n/4 or n.

        int[] targetElements = new int[] {arr[targetCount], arr[2*targetCount], arr[3*targetCount], arr[4*targetCount]};

        for (int element : targetElements) {
            int startIndex = findStartIndex(arr, element);
            int endIndex = findEndIndex(arr, element);

            if (endIndex - startIndex + 1 > targetCount)
                return element;
        }
        return -1;
    }

    private int findStartIndex(int[] arr, int element) {
        int start = 0,
                end = arr.length - 1;

        while (start <= end) {
            if (arr[start] == element) {
                return start;
            }

            int mid = start + (end - start) / 2;
            if (arr[mid] > element) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }

    private int findEndIndex(int[] arr, int element) {
        int start = 0,
                end = arr.length - 1;

        while (start <= end) {
            if (arr[end] == element) {
                return end;
            }

            int mid = start + (end - start) / 2;
            if (arr[mid] > element) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Q1287_Element_Appearing_More_Than_25_pc_In_Sorted_Array sol = new Q1287_Element_Appearing_More_Than_25_pc_In_Sorted_Array();

        int[] arr =   { 1,2,2,6,6,6,6,7,10 };

        int result = sol.findSpecialInteger(arr);
        System.out.println(result);
    }
}
