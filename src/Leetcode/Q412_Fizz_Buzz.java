package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q412_Fizz_Buzz {
    public List<String> fizzBuzz(int n) {
        if (n <=0)
            return null;
        List<String> result = new LinkedList<String>();

        for (int i=1; i <=n ;i++) {
            if (i%15 == 0) {
                result.add("FizzBuzz");
            } else if (i%3 == 0) {
                result.add("Fizz");
            } else if (i%5 == 0) {
                result.add("Buzz");
            } else {
                result.add(""+i);
            }
        }
        return result;
    }
}
