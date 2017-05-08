package com.whitespace.raghav.Misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 9/13/15.
 */
public class Divide {

    static void findingDigits(int[] foo) {
        for (int number : foo) {
            int count = 0;
            while (number > 0) {
                int digit = number % 10;
                if (digit != 0 && number % digit == 0) {
                    count++;
                }
                number = number / 10;

            }
            System.out.println(count);
        }

    }

    public static void main(String[] args) {
        int[] arr = {12, 123, 1234};
        findingDigits(arr);

    }
}
