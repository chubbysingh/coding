package Leetcode;

import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * <p>
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 */

public class Q281_Zigzag_Iterator {
    private List<Integer> v1;
    private List<Integer> v2;
    private int i;
    private int j;
    private int listId;

    public Q281_Zigzag_Iterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.i = 0;
        this.j = 0;
        this.listId = 0;
    }

    public int next() {
        int result = 0;
        if (i >= v1.size()) {
            result = v2.get(j);
            j++;
        } else if (j >= v2.size()) {
            result = v1.get(i);
            i++;
        } else {
            if (listId == 0) {
                result = v1.get(i);
                i++;
                listId = 1;
            } else {
                result = v2.get(j);
                j++;
                listId = 0;
            }
        }

        return result;
    }

    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }
}
