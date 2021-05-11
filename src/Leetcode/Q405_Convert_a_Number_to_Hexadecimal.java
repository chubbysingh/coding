package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q405_Convert_a_Number_to_Hexadecimal {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex(int num) {
        if(num == 0)
            return "0";

        String result = "";

        while(num != 0){
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }
}
