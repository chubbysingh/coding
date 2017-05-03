package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q492_Construct_the_Rectangle {
    public int[] constructRectangle(int area) {
        int res[] = new int[2];
        if (area == 0)
            return res;

        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }
        res[0] = area / width;
        res[1] = width;
        return res;
    }
}
