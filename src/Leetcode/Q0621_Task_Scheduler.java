package Leetcode;

import java.util.Arrays;

/**
 * Return the least number of units of times that
 * the CPU will take to finish all the given tasks.
 */
public class Q0621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] slots = new int[26];

        for (int i=0; i < tasks.length; i++) {
            slots[tasks[i] - 'A']++;
        }

        Arrays.sort(slots);

        int groups = slots[25] - 1,
                idleSlots = groups * n;

        for (int i = 24; i >= 0 ; i--) {
            idleSlots -= Math.min(slots[i], groups);
        }

        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }

    public static void main(String[] args) {
        Q0621_Task_Scheduler sol = new Q0621_Task_Scheduler();

        char[] tasks = { 'A','A','A','B','B','B' };
        int result = sol.leastInterval(tasks, 2);

        System.out.println(result);
    }
}
