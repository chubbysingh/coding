package Leetcode;

import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

public class Q385_Mini_Parser {
    public NestedInteger deserialize(String s) {
        if (s.contains("[")) {
            NestedInteger ans = new NestedInteger();
            if (s.length() > 2) {
                int begin = 1;
                char[] cs = s.toCharArray();
                int count = 0;
                for (int i = 1; i < s.length() - 1; i++) {
                    if (cs[i] == ',' && count == 0) {
                        ans.add(deserialize(s.substring(begin, i)));
                        begin = i + 1;
                    }
                    if (cs[i] == '[' || cs[i] == ']') {
                        count += (92 - cs[i]);
                    }
                }
                ans.add(deserialize(s.substring(begin, s.length() - 1)));
            }
            return ans;
        }
        return new NestedInteger(Integer.valueOf(s));
    }

    class NestedInteger {

        public NestedInteger() {

        }

        public NestedInteger(int value) {

        }

        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return 1;
        }

        public void setInteger(int value) {

        }

        public void add(NestedInteger ni) {

        }

        public List<NestedInteger> getList() {
            return null;
        }
    }
}





