package com.whitespace.raghav.Misc;

import java.util.Random;

/**
 * Created by rbhatnagar2 on 2/10/16.
 */
public class RandomNumberGenerator {
    static Random ran = new Random();

    public static int randInt() {

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = ran.nextInt(100) + 1;

        return randomNum;
    }

    public static void getRandomNumber() {
        int[] bucket = new int[10];
        for (int bucketInt : bucket) {
            bucketInt = 0;
        }


        for (int i = 0; i < 100; i++) {
            int random = randInt();

            //int cell = random%10 - 1;

            if (random <= 10) {
                bucket[0]++;
            } else if (random <= 20) {
                bucket[1]++;
            } else if (random <= 30) {
                bucket[2]++;
            } else if (random <= 40) {
                bucket[3]++;
            } else if (random <= 50) {
                bucket[4]++;
            } else if (random <= 60) {
                bucket[5]++;
            } else if (random <= 70) {
                bucket[6]++;
            } else if (random <= 80) {
                bucket[7]++;
            } else if (random <= 90) {
                bucket[8]++;
            } else if (random <= 100) {
                bucket[9]++;
            }


            System.out.println(random);


        }
        System.out.println("BucketList");
        for (int bucketCell : bucket) {
            System.out.println(bucketCell);
        }
    }

    public static void main(String[] args) {
        RandomNumberGenerator.getRandomNumber();
    }

}
