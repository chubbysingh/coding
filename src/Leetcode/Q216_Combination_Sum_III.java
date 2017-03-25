package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        helper(result, curr, k, 1, n);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> curr, int k, int start, int sum){
        if(sum<0){
            return;
        }

        if(sum==0 && curr.size()==k){
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        for(int i=start; i<=9; i++){
            curr.add(i);
            helper(result, curr, k, i+1, sum-i);
            curr.remove(curr.size()-1);
        }
    }
}
