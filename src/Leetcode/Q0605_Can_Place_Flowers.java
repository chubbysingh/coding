package Leetcode;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's,
 * where 0 means empty and 1 means not empty, and an integer n,
 * return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 */
public class Q0605_Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i=0; i< flowerbed.length; i++) {
            if (flowerbed[i] == 0 // current val is 0
                    && (i == 0 || flowerbed[i - 1] == 0) //previous val is 0 or does not exist
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) //next val is zero or does not exist
            {
                flowerbed[i++] = 1;
                count++;
            }

            if(count>=n)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Q0605_Can_Place_Flowers sol = new Q0605_Can_Place_Flowers();

        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;

        boolean result = sol.canPlaceFlowers(flowerbed, n);
        System.out.println(result);
    }
}
