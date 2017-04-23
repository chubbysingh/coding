package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q241_Different_Ways_to_Add_Parentheses {
    public List<Integer> diffWaysToCompute(String input) {
        //result
        List<Integer> ret = new LinkedList<Integer>();

        //loop through all the input characters
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '*' || c == '+' ) {

                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);

                // solve part1 and part2 recursively
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);

                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int ans = 0;
                        switch (input.charAt(i)) {
                            case '+': ans = p1+p2;
                                break;
                            case '-': ans = p1-p2;
                                break;
                            case '*': ans = p1*p2;
                                break;
                        }
                        ret.add(ans);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }

    public static void main(String[] args) {
        Q241_Different_Ways_to_Add_Parentheses sol = new Q241_Different_Ways_to_Add_Parentheses();
        String input = "2-1-1";

        List<Integer> res = sol.diffWaysToCompute(input);
        System.out.println(res);
    }
}
