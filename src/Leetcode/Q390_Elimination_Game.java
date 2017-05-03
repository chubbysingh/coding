package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q390_Elimination_Game {
    /**
     * My idea is to update and record head in each turn. when the total number becomes 1, head is the only number left.
     * When will head be updated?
     * if we move from left
     * if we move from right and the total remaining number % 2 == 1
     * like 2 4 6 8 10, we move from 10, we will take out 10, 6 and 2, head is deleted and move to 4
     * like 2 4 6 8 10 12, we move from 12, we will take out 12, 8, 4, head is still remaining 2
     * then we find a rule to update our head.
     **/
    public int lastRemaining(int n) {
        boolean isLeft = true;
        int remaining = n;
        int step = 1;
        int head = 1;

        while (remaining > 1) {
            if (isLeft || remaining % 2 == 1)
                head = head + step;
            step = step * 2;
            remaining /= 2;
            isLeft = !isLeft;
        }
        return head;
    }
}
