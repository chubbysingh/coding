package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q151_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        if (s.length()<1) {
            return s;
        }
        String a = "";
        String answer = "";
        boolean flag=true;
        for (int i = s.length() - 1; i >= 0; i--) {
            String k = s.substring(i, i + 1);
            if (flag) {
                if (k.equals(" ")) {

                }else {
                    flag=false;
                    a=k+a;
                }
            }else {
                if (k.equals(" ")) {
                    flag=true;
                    answer=answer+" "+a;
                    a="";
                }else {
                    a=k+a;
                }
            }
        }
        if (a.length()!=0) {
            answer=answer+" "+a;
        }
        if (answer.length()==0) {
            return "";
        }
        while (answer.substring(0,1).equals(" ")) {
            if (answer.length()==1) {
                return "";
            }
            answer=answer.substring(1, answer.length());
        }
        return answer;
    }
}
