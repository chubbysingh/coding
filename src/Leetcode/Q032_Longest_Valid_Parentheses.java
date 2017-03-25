package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q032_Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        int length=s.length();
        if (length==0) {
            return 0;
        }
        int ans=0;
        char[] c=s.toCharArray();
        int[] vals=new int[length];
        for (int i = length-2; i >= 0; i--) {
            if (c[i]=='(') {
                int t=i+1+vals[i+1];
                if (t<length&&c[t]==')') {
                    vals[i]=vals[i+1]+2;
                    vals[i]+=((t+1<length)?vals[t+1]:0);
                    ans=ans<vals[i]?vals[i]:ans;
                }
            }
        }
        return ans;
    }
}
