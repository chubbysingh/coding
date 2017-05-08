package com.whitespace.raghav.LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 10/12/15.
 * <p>
 * Given a nested list of integers,
 * return the sum of all integers in the list
 * weighted by their depth
 * For example,
 * given the list {{1,1},2,{1,1}}
 * the function should return 10
 * (four 1&#039;s at depth 2, one 2 at depth 1)
 */
public class SumByDepth {

    private static int sum(List<NestedInteger> nestedList, int depth) {

        int sum = 0;
        if (nestedList == null)
            return 0;

        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger())
                sum += depth * nestedInteger.getInteger();
            else
                sum += sum(nestedInteger.getList(), depth + 1);
        }

        return sum;
    }

    public static void main(String[] args) {

        //Data populate
        NestedInteger i1 = new NestedInteger();
        i1.setData(1);

        NestedInteger i2 = new NestedInteger();
        i2.setData(1);

        List<NestedInteger> list = new LinkedList<NestedInteger>();
        list.add(i1);
        list.add(i2);

        NestedInteger nestedList = new NestedInteger();
        nestedList.setList(list);

        NestedInteger i4 = new NestedInteger();
        i4.setData(2);

        List<NestedInteger> request = new LinkedList<NestedInteger>();

        request.add(nestedList);
        request.add(i4);
        request.add(nestedList);

        System.out.println(sum(request, 1));

    }

}

class NestedInteger {
    Integer data;
    List<NestedInteger> list;

    public void setData(Integer data) {
        this.data = data;
    }

    public void setList(List<NestedInteger> list) {
        this.list = list;
    }

    // Returns true if this NestedInteger holds a single integer, rather than a nested list
    public boolean isInteger() {
        return (data != null);
    }

    // Returns the single integer that this NestedInteger holds, if it holds a single integer
    // Returns null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return data;
    }

    // Returns the nested list that this NestedInteger holds, if it holds a nested list
    // Returns null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }
}
