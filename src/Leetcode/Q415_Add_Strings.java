package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q415_Add_Strings {
    public String addStrings(String num1, String num2) {
        StringBuilder result= new StringBuilder();
        int l1 = num1.length()-1,
                l2 = num2.length()-1;

        int carry = 0;
        while(l1 >=0 || l2 >= 0) {
            int sum = carry;
            carry = 0;
            if (l1 >= 0) {
                sum += Integer.parseInt(String.valueOf(num1.charAt(l1)));
                l1--;
            }
            if (l2 >= 0) {
                sum += Integer.parseInt(String.valueOf(num2.charAt(l2)));
                l2--;
            }

            carry = sum/10;
            sum = sum%10;

            result.append(sum);
        }
        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }
}
