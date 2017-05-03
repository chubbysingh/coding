package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move
 * and therefore the other person will be the winner.
 * <p>
 * Write a function to determine if the starting player can guarantee a win.
 * <p>
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 */
public class Q294_Flip_Game_II {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        return canWinHelper(s.toCharArray());
    }

    public boolean canWinHelper(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';

                boolean win = canWinHelper(arr);

                arr[i] = '+';
                arr[i + 1] = '+';

                //if there is a flip which makes the other player lose, the first play wins
                if (!win) {
                    return true;
                }
            }
        }

        return false;
    }
}
