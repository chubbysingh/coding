package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 3/15/17.
 */
public class Q339_Nested_List_Weight_Sum {
    public int depthSumRecursive(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth){
        if(nestedList==null||nestedList.size()==0)
            return 0;

        int sum=0;
        for(NestedInteger ni: nestedList){
            if(ni.isInteger()){
                sum += ni.getInteger() * depth;
            }else{
                sum += helper(ni.getList(), depth+1);
            }
        }

        return sum;
    }

    public int depthSum(List<NestedInteger> nestedList) {
        int sum=0;

        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        Queue<Integer> depth = new LinkedList<Integer>();

        for(NestedInteger ni: nestedList){
            queue.offer(ni);
            depth.offer(1);
        }

        while(!queue.isEmpty()){
            NestedInteger top = queue.poll();
            int dep = depth.poll();

            if(top.isInteger()){
                sum += dep*top.getInteger();
            }else{
                for(NestedInteger ni: top.getList()){
                    queue.offer(ni);
                    depth.offer(dep+1);
                }
            }
        }

        return sum;
    }

}
