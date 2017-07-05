package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q097_Interleaving_String {
    public static boolean isInterleave(String s1, String s2, String s3) {
        return isInterleaveChr(s1.toCharArray(), s2.toCharArray(), s3.toCharArray());
    }

    private static boolean isInterleaveChr(char str1[], char str2[], char str3[]){
        boolean T[][] = new boolean[str1.length +1][str2.length +1];

        if(str1.length + str2.length != str3.length){
            return false;
        }

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length; j++){
                int l = i + j -1;
                if(i == 0 && j == 0){
                    T[i][j] = true;
                }
                else if(i == 0){
                    if(str2[j-1] == str3[j-1] ){
                        T[i][j] = T[i][j-1];
                    }
                }
                else if(j == 0){
                    if(str1[i-1] == str3[i-1]){
                        T[i][j] = T[i-1][j];
                    }
                }
                else{
                    if (str1[i-1] == str3[i+j-1] ) {
                        T[i][j] = T[i-1][j] ;
                    }
                    if (str2[j-1] == str3[i+j-1]) {
                        T[i][j] = T[i][j] || T[i][j-1];
                    }
                }
            }
        }
        return T[str1.length][str2.length];
    }
}
