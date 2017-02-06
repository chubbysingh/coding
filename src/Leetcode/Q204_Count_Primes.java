package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q204_Count_Primes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for(int i=0; i<n; i++) {
            isPrime[i] = true;
        }

        for(int i=2; i<n;i++) {
            if (isPrime[i]) {
                count++;
                for(int j=2; i*j < n; j++) {
                    isPrime[i*j]=false;
                }
            }
        }
        return count;

    }
}
