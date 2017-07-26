package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them,
 * there may exist one celebrity.
 * <p>
 * The definition of a celebrity is that all the other n - 1 people know him/her
 * but he/she does not know any of them.
 * <p>
 * Now you want to find out who the celebrity is or verify that there is not one.
 * The only thing you are allowed to do is to ask questions like:
 * "Hi, A. Do you know B?" to get information of whether A knows B.
 * You need to find out the celebrity (or verify there is not one) by asking
 * as few questions as possible (in the asymptotic sense).
 * <p>
 * You are given a helper function bool knows(a, b)
 * which tells you whether A knows B. Implement a function int findCelebrity(n),
 * your function should minimize the number of calls to knows.
 * <p>
 * Note: There will be exactly one celebrity if he/she is in the party.
 * Return the celebrity's label if there is a celebrity in the party.
 * If there is no celebrity, return -1.
 */
public class Q277_Find_the_Celebrity {
    /**
     * O(n)
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }

        int left = 0;
        int right = n - 1;

        // Step 1: Find the potential candidate
        while (left < right) {
            if (knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }

        // Step 2: Validate the candidate
        int candidate = right;
        for (int i = 0; i < n; i++) {
            if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
                return -1;
            }
        }

        return candidate;
    }

    /**
     * O(n^2)
     * @param n
     * @return
     */
    public int findCelebritySlow(int n) {
        if (n <= 1) {
            return -1;
        }

        int[] inDegree = new int[n];
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    outDegree[i]++;
                    inDegree[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    private boolean knows(int l, int r) {
        return false;
    }
}
