package Leetcode;

/**
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Time Complexity: O(max(N1, N2))
 *  *      where N1 and N2 are length of num1 and num2
 *  * Space Complexity: O(max(N1, N2)),
 *  *      because the length of the new string is at most max(N1, N2) + 1
 *
 */
public class Q067_Add_Binary {
    public String addBinary(String a, String b) {
        int lengthA = a.length() - 1,
            lengthB = b.length() - 1,
            carry = 0;

        // Creates the sum in reverse order and reverses the string in the end
        StringBuffer sb = new StringBuffer();

        while (lengthA >= 0 || lengthB >= 0) {
            int sum = carry;
            carry = 0;

            if (lengthA >= 0) {
                sum += a.charAt(lengthA) - '0';
                lengthA--;
            }
            if (lengthB >= 0) {
                sum += b.charAt(lengthB) - '0';
                lengthB--;
            }
            if (sum > 1) {
                carry = 1;
                sum = sum % 2;
            }
            sb.append(sum);

        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Q067_Add_Binary sol = new Q067_Add_Binary();
        String a = "1010";
        String b = "1011";

        String result = sol.addBinary(a, b);
        System.out.println(result); //10101

    }
}
