package com.whitespace.raghav.Arrays;

/**
 * Created by rbhatnagar2 on 10/16/15.
 */
public class SearchInRotatedArray {
    private static int search(int[] arr, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = start + (end - start)/2;

        if (arr[mid] == target)
            return mid;

        else if (arr[mid] < arr[end]) {
            // The later half is sorted
            if (arr[mid] < target && target <= arr[end]) {
                // Target is in the later half sorted array
                return search(arr, target, mid+1, end);
            }
            else {
                // Target is in the 1st half
                return search(arr, target, start, mid-1);
            }

        } else if (arr[mid] > arr[end]){
            if (arr[start] < target && target < arr[mid])
                return search(arr, target, start, mid-1);
            else
                return search(arr, target, mid+1, end);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {20, 40, 50, 5, 7, 9, 11, 15, 18};
        System.out.println(search(arr, 50, 0, arr.length));
    }
}
