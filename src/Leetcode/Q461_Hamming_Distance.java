package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 */
public class Q461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        int result = 0;
        int xor = x ^ y;

        while (xor > 0) {
            result += xor & 1;
            xor = xor >> 1;
        }
        return result;
    }

}
