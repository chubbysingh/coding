package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q273_Integer_to_English_Words {

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final int BILLION = 1000000000,
            MILLION = 1000000,
            THOUSAND = 1000,
            HUNDRED = 100;

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        if (num >= BILLION) {
            words += " " + numberToWords(num / BILLION) + " Billion";
            num %= BILLION;
        }

        if (num >= MILLION) {
            words += " " + numberToWords(num / MILLION) + " Million";
            num %= MILLION;
        }

        if (num >= THOUSAND) {
            words += " " + numberToWords(num / THOUSAND) + " Thousand";
            num %= THOUSAND;
        }

        if (num >= HUNDRED) {
            words += " " + numberToWords(num/HUNDRED) + " Hundred";
            num %= HUNDRED;
        }

        if (num >= 20) {
            words += " " + TENS[num/10] + " ";
            num %= 10;
        }

        if (num > 0) {
            words += " " + LESS_THAN_20[num] + " ";
        }

        return words.trim().replace("  ", " ");
    }

    public static void main(String[] args) {
        Q273_Integer_to_English_Words sol = new Q273_Integer_to_English_Words();
        int num = 100;
        System.out.println(sol.numberToWords(num));
    }
}
