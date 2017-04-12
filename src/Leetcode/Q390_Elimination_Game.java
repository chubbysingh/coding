package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q390_Elimination_Game {
    public int lastRemaining(int n) {
        boolean isLeft = true;
        int remaining = n;
        int step = 1;
        int head = 1;

        while (remaining > 1) {
            if (isLeft || remaining%2==1)
                head = head + step;
            step = step*2;
            remaining /= 2;
            isLeft = !isLeft;
        }
        return head;
    }
}
