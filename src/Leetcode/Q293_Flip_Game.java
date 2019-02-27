package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move
 * and therefore the other person will be the winner.
 * <p>
 * Write a function to compute all possible states of the string after one valid move.
 */

public class Q293_Flip_Game {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();

        if (s == null)
            return result;

        char[] arr = s.toCharArray();
        // loop till second last element to avoid IndexOutOfBoundException
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && arr[i] == '+') {
                // flip two consecutive "++" into "--"
                arr[i] = '-';
                arr[i + 1] = '-';
                result.add(new String(arr));
                // revert the change
                arr[i] = '+';
                arr[i + 1] = '+';
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Q293_Flip_Game sol = new Q293_Flip_Game();

        String s = "++++";
        List<String> result = sol.generatePossibleNextMoves(s);

        //   --++
        //   +--+
        //   ++--
        for (String p : result) {
            System.out.println(p);
        }
    }
}
