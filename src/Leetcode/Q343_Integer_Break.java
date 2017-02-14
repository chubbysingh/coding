package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q343_Integer_Break {
    public int integerBreakOne(int n) {
        int[] dp = new int[n+1];
        for (int i=0; i<dp.length; i++) {
            dp[i] = i;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<i+1; j++){
                if(i+j<=n){
                    dp[i+j]=Math.max(dp[i] * dp[j], dp[i+j]);
                }
            }
        }
        return dp[n];
    }

    public int integerBreakTwo(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        if (n==3) return 3;
        if (n==4) return 4;

        int result=1;
        // If multiple of 3, maxSUm would be 3*3*3*3....m times
        if(n%3==0){
            int m = n/3;
            result = (int) Math.pow(3, m);
        }
        // If not, get multiple of 3 * 2
        else if(n%3==2){
            int m=n/3;
            result = (int) Math.pow(3, m) * 2;
        }
        // We dont want to be left with 1, so multiples of 3 * 4
        else if(n%3==1){
            int m=(n-4)/3;
            result = (int) Math.pow(3, m) *4;
        }

        return result;
    }
}
