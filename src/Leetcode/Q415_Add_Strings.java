package Leetcode;

/**
 * Given two non-negative integers, num1 and num2 represented as string,
 * return the sum of num1 and num2 as a string.
 *
 * Time Complexity: O(max(N1, N2))
 *      where N1 and N2 are length of num1 and num2
 * Space Complexity: O(max(N1, N2)),
 *      because the length of the new string is at most max(N1, N2) + 1
 */
public class Q415_Add_Strings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int l1 = num1.length() - 1,
                l2 = num2.length() - 1;

        int carry = 0;
        while (l1 >= 0 || l2 >= 0) {
            int sum = carry;
            carry = 0;
            if (l1 >= 0) {
                sum += num1.charAt(l1) - '0';
                l1--;
            }
            if (l2 >= 0) {
                sum += num2.charAt(l2) - '0';
                l2--;
            }

            carry = sum / 10;
            sum = sum % 10;

            result.append(sum);
        }
        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Q415_Add_Strings sol = new Q415_Add_Strings();
        String result = sol.addStrings("1234", "567");

        System.out.println(result);
    }
}
