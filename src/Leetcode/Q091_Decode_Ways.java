package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q091_Decode_Ways {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int len = s.length();
        int[] T = new int[len + 1];

        T[0] = 1;
        T[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= len; i++) {
            T[i] = s.charAt(i - 1) != '0' ? T[i - 1] : 0;
            if (isValid(s.substring(i - 2, i))) {
                T[i] += T[i - 2];
            }
        }
        return T[T.length - 1];
    }

    // Is valid 2 digit number that can be converted into an alphabet
    private boolean isValid(String s) {
        int n = Integer.parseInt(s);
        return n >= 10 && n <= 26;
    }

}
