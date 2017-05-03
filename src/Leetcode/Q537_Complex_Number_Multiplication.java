package Leetcode;

/**
 * Created by rbhatnagar2 on 4/21/17.
 */
public class Q537_Complex_Number_Multiplication {
    public String complexNumberMultiply(String a, String b) {
        String result = "";
        String[] A = a.split("\\+");
        String[] B = b.split("\\+");
        int a1 = Integer.parseInt(A[0]);
        int b1 = Integer.parseInt(A[1].replace("i", ""));

        int a2 = Integer.parseInt(B[0]);
        int b2 = Integer.parseInt(B[1].replace("i", ""));

        int a1a2 = a1 * a2;
        int b1b2 = b1 * b2;
        int a1b2a2b1 = (a1 * b2) + (b1 * a2);

        String afinal = (a1a2 + (-1 * b1b2)) + "";
        String bfinal = a1b2a2b1 + "i";
        result = afinal + "+" + bfinal;
        return result;
    }
}
