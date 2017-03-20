package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Given an integer n, generate the nth sequence.
 *
 */
public class Q038_Count_and_Say {
    public String countAndSay(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            //Append the last one which fell off the for loop
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));

            result = sb.toString();
            i++;
        }

        return result;
    }
}
