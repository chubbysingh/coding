package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q374_Guess_Number_Higher_or_Lower {
    public int guessNumber(int n) {

        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res > 0)
                low = mid + 1;
            else
                high = mid;
        }
        return -1;
    }

    /**
     * Given API function
     *
     * @param mid
     * @return
     */
    private int guess(int mid) {
        return 0;
    }
}
