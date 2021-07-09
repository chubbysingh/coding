package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree,
 * return the average value of the nodes on each level in the form of an array.
 */
public class Q0636_Exclusive_Time_of_Functions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];

        Stack<Log> stack = new Stack<>();

        for (String content : logs) {
            Log log = new Log(content);

            if (log.isStart) {
                stack.push(log);
            } else {
                Log start = stack.pop();

                result[start.id] += log.time - start.time + 1;

                if (!stack.isEmpty()) {
                    result[stack.peek().id] -= log.time - start.time + 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        Q0636_Exclusive_Time_of_Functions sol = new Q0636_Exclusive_Time_of_Functions();
        int[] result = sol.exclusiveTime(4, logs);
        System.out.println(Arrays.toString(result));
    }

    class Log {
        int id;
        boolean isStart;
        int time;

        Log(String content) {
            String[] split = content.split(":");

            id = Integer.parseInt(split[0]);
            isStart = split[1].equals("start");
            time = Integer.parseInt(split[2]);
        }
    }
}
