package Leetcode;

import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * Given a sequence of words, check whether it forms a valid word square.

 A sequence of words forms a valid word square
 if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

 */
public class Q422_Valid_Word_Square {
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0){
            return true;
        }
        int n = words.size();
        for(int i=0; i<n; i++){
            for(int j=0; j<words.get(i).length(); j++){
                if(j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }
}
