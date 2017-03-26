package Leetcode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q071_Simplify_Path {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }

        String[] arr = path.split("/");

        Stack<String> stack = new Stack<String>();

        for (String str : arr) {
            // str can be :
            // a.) "." or empty (ignore)
            // b.) ".." (go 1 level up) [pop from stack]
            // c.) any valid name [push into stack]

            if (str.isEmpty() || str.equals("."))
                continue;

            else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else {
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }

        for (String str : stack) {
            sb.append("/" + str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Q071_Simplify_Path sol = new Q071_Simplify_Path();
        String path = "/a/./b/../../c/";

        String result = sol.simplifyPath(path);
        System.out.println(result);
    }
}
