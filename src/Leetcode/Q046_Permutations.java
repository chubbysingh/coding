package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Given a collection of distinct numbers, return all possible permutations.
 *
 */
public class Q046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Q046_Permutations sol = new Q046_Permutations();

        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = sol.permute(nums);
        System.out.println("Size: " + res.size());
        System.out.println(res);
    }
}
