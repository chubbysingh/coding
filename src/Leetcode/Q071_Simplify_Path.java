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

        String delim = "[/]+";
        String[] arr = path.split(delim);

        Stack<String> stack = new Stack<String>();

        for (String str : arr) {
            if(str.equals("/")){
                continue;
            }
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals(".") && !str.isEmpty()) {
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
}
