package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 *
 */
public class Q022_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        buildList(list, 0, n, ""); // resultList, openParenthesis, remainingParenthesis, chars
        return list;
    }

    // opened : number of opened parenthesis in s that do not have their closing one yet
    // remaining : number of opened parenthesis that I can still add to s
    private void buildList(List<String> list, int opened, int remaining, String s){
        if(remaining == 0 && opened == 0){ // I cannot add anymore '(' and they are all closed
            list.add(s);
        } else{
            if(remaining > 0)
                buildList(list, opened+1, remaining-1, s+'(');
            if(opened > 0)
                buildList(list, opened-1, remaining, s + ')');
        }
    }
}
