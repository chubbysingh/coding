package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 *
 */
public class Q043_Multiply_Strings {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length()+num2.length()];

        //multiply each digit and sum at the corresponding positions
        for(int i=0; i<n1.length(); i++){
            for(int j=0; j<n2.length(); j++){
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }

        //calculate each digit
        for(int i=0; i<d.length; i++){
            int mod = d[i]%10;
            int carry = d[i]/10;
            d[i] = mod;

            if(carry > 0){
                d[i+1] += carry;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=d.length-1; i>=0; i--) {
            sb.append(d[i]);
        }

        //remove front 0's
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
