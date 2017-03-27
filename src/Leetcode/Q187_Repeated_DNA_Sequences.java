package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q187_Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set=new HashSet<String>();
        Set<String> repeated=new HashSet<String>();

        List<String> ans=new LinkedList<String>();

        for (int i = 0; i < s.length()-9; i++) {

            String k=s.substring(i,i+10);

            if (!set.contains(k)) {
                set.add(k);
            }
            // Its repeated. Check for duplication
            else if(!repeated.contains(k)){
                repeated.add(k);
                ans.add(k);
            }
        }
        return ans;
    }
}
