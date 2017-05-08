package com.whitespace.raghav.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of "array range", return an optimized array by deleting subarrays.
 * INPUT: [(2,6),(3,5),(7,21),(20,21)]
 * OUTPUT: [(2,6),(7,21)]
 * Reason: (3,5) is a subarray of (2,6) and (20,21) is a subarray of (7,21)
 * http://careercup.com/question?id=5676298150084608
 * Created by rbhatnagar2 on 10/22/15.
 */
public class ArrayRange {
    public static List<Pair> smallerSubArray(Pair[] input) {
        if (input == null || input.length < 2)
            return Arrays.asList(input);

        Arrays.sort(input);
        List<Pair> output = new ArrayList<Pair>();
        output.add(input[0]);

        for (int i = 0; i < input.length; i++) {

            if (!input[i].isInside(output.get(output.size() - 1))) {
                if (output.get(output.size() - 1).isInside(input[i])) {
                    output.remove(output.size() - 1);
                }

                output.add(input[i]);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Pair[] input = {
                new Pair(2, 6),
                new Pair(3, 5),
                new Pair(7, 21),
                new Pair(20, 21)
        };
        List<Pair> output = smallerSubArray(input);
        System.out.println(output);
    }
}

class Pair implements Comparable<Pair> {
    Integer low, high;

    Pair(int low, int high) {
        this.low = low;
        this.high = high;
    }

    boolean isInside(Pair other) {
        return other != null &&
                other.low <= this.low &&
                other.high >= this.high;
    }

    @Override
    public int compareTo(Pair other) {
        return other.low == this.low ?
                this.high.compareTo(other.high) : this.low.compareTo(other.low);
    }

    public String toString() {
        return ("(" + this.low + "," + this.high + ")");
    }
}
