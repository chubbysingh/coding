package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        backtrack(list,new ArrayList<Integer>(),n,k,1);
        return list;
    }
    public void backtrack(List<List<Integer>> list,ArrayList<Integer> templist,int n, int k,int start){
        if(templist.size()==k)
            list.add(new ArrayList<>(templist));
        else if(templist.size()>k)return;

        for(int i=start;i<=n;i++){
            templist.add(i);
            backtrack(list,templist,n,k,i+1);
            templist.remove(templist.size()-1);
        }
    }
}
