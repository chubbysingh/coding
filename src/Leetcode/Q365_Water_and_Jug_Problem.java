package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q365_Water_and_Jug_Problem {
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if (x + y < z) return false;
        //case x or y is zero
        if (x == z || y == z || x + y == z) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z % gcd(x, y) == 0;
    }

    public int gcd(int a, int b){
        return (b == 0) ? a : gcd(b, a % b);
    }
}
