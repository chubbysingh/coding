
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


    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.compressedVersion("AAABBZZDDD"));
        System.out.println(sol.decompressString("3A2B2Z3D"));
    }
}
