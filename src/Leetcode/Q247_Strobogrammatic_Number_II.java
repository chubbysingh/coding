package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees
 * (looked at upside down).

 Find all strobogrammatic numbers that are of length = n.

 For example, Given n = 2, return ["11","69","88","96"].
 *
 */
public class Q247_Strobogrammatic_Number_II {
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }
    private List<String> helper( int n, int N){
        List<String> all = new LinkedList<String>();
        if(n == 1){
            all.add("0");
            all.add("1");
            all.add("8");
        }else if(n==2){
            if(N !=2 )
                all.add("00");
            all.add("11");
            all.add("88");
            all.add("96");
            all.add("69");
        }else{
            List<String> newAll = helper(n-2, N );
            for(String tmp : newAll){
                if( N!= n )
                    all.add("0"+tmp+"0");
                all.add("1"+tmp+"1");
                all.add("8"+tmp+"8");
                all.add("6"+tmp+"9");
                all.add("9"+tmp+"6");
            }
        }
        return all;
    }
}
