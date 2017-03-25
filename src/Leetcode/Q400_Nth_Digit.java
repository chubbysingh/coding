package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q400_Nth_Digit {
    public int findNthDigit(int n) {
        int length=1;
        long count=9;
        while (n>count*length) {
            n-=count*length;
            length++;
            count*=10;
        }
        long target=count/9+(n-1)/length;
        return Integer.parseInt(String.valueOf(target).substring((n-1)%length, (n-1)%length+1));
    }
}
