import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/21/17.
 */
public class Solution {

    public String compressedVersion(String str) {
        //I/p : AAABBZZDDD
        //O/p : 3A2B2Z3D
        if (str == null || str.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i=0; i<str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1))
                count++;
            else {
                sb.append(count).append(str.charAt(i));
                count = 1;
            }
        }
        sb.append(count).append(str.charAt(str.length()-1));
        return sb.toString();

    }

    public String decompressString(String str) {
        //I/p : 3A2B2Z3D
        //O/p : AAABBZZDDD

        if (str == null || str.length() == 0)
            return "";

        //int count = 0;
        int index = 0, count=0;
        StringBuilder sb = new StringBuilder();

        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index)))
                count = count*10 + ( str.charAt(index) - '0');
            else {
                char c = str.charAt(index);
                for (int i=0; i<count; i++) {
                    sb.append(c);

                }
                count=0;
            }
            index++;
        }
        return sb.toString();
    }

    public List<List<Integer>> pascalTriangle(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        int count = 1, index=0;
        while(index < nums.length) {
            List<Integer> list = new LinkedList<>();

            for (int j = 0; j < count; j++) {
                list.add(nums[index]);
                index++;
            }

            res.add(list);
            count++;
        }

        return res;

    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        List<List<Integer>> res = sol.pascalTriangle(nums);
        System.out.println(res);

        System.out.println(sol.compressedVersion("AAABBZZDDD"));
        System.out.println(sol.decompressString("3A2B2Z3D"));
    }
}
