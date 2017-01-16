package Search;

/**
 * Created by rbhatnagar2 on 9/13/15.
 */
public class BinarySearch {
    private static int bSearch(int[] arr, int target) {
        int index = -1;

        int start = 0, end = arr.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }

        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 7, 9, 12};

        int index = bSearch(arr, 4);
        System.out.println(index);
    }
}
