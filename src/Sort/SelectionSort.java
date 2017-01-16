package Sort;

/**
 * Created by rbhatnagar2 on 6/24/15.
 */
public class SelectionSort {

    public static int[] doSelection(int[] arr) {
        if (arr == null) {
            return null;
        }

        for (int i = 0 ; i < arr.length-1 ; i++) {
            int minIndex = i;
            for (int j = i + 1 ; j < arr.length ; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int smallerNumber = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }


}
