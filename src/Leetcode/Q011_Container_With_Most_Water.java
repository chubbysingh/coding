package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q011_Container_With_Most_Water {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;

        int leftIndex = 0, rightIndex = height.length-1;
        int max = 0;

        while (leftIndex < rightIndex) {
            int area = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            max = Math.max(max, area);

            if (height[leftIndex] < height[rightIndex])
                leftIndex++;
            else
                rightIndex--;
        }
        return max;
    }
}
