package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q187_Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map=new HashMap<String, Integer>();
        Map<String,Integer> trash=new HashMap<String, Integer>();
        List<String> ans=new ArrayList<String>();
        for (int i = 0; i < s.length()-9; i++) {
            String k=s.substring(i,i+10);
            if (map.get(k)==null) {
                map.put(k, 1);
            }else if(trash.get(k)==null){
                trash.put(k, 1);
                ans.add(k);
            }
        }
        return ans;
    }
}
