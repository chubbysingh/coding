package Sort;

/**
 * Created by rbhatnagar2 on 6/24/15.
 */
public class testSort {
    public static void main(String[] arr) {
        int[] arr1 = {10,34,2,56,7,67,88,42};

        int[] arr2 = SelectionSort.doSelection(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }

    }
}
