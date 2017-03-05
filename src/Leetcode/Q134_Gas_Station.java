package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }

        int sum = 0;
        int total = 0;
        int startIdx = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            total += (gas[i] - cost[i]);

            if (sum < 0) {
                sum = 0;
                startIdx = i + 1;
            }
        }

        return total >= 0 ? startIdx % gas.length : -1;
    }
}
