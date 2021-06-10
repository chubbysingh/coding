package Leetcode;

import java.util.Random;

public class Q528_Random_Pick_with_Weight {

    Random rand;
    int[] sums;

    public Q528_Random_Pick_with_Weight(int[] w) {
        for(int i=1; i<w.length; ++i)
            w[i] += w[i-1];
        this.sums = w;

        this.rand = new Random();
    }

    public int pickIndex() {
        int lastNumber = sums[sums.length-1] + 1;
        int idx = rand.nextInt(lastNumber) ;
        int low = 0, high = sums.length - 1;
        // search position
        while(low < high){
            int mid = low + (high-low)/2;
            if(sums[mid] == idx)
                return mid;
            else if(sums[mid] < idx)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
