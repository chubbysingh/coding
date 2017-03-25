package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q299_Bulls_and_Cows {
    public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 ||
                guess == null || guess.length() == 0) {
            return "0A0B";
        }

        int numBulls = 0;
        int numCows = 0;

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: calculate the number of bulls and update the map
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                numBulls++;
            } else {
                // Update the map
                if (map.containsKey(s)) {
                    int freq = map.get(s);
                    freq++;
                    map.put(s, freq);
                } else {
                    map.put(s, 1);
                }
            }
        }

        // Step 2: calculate the number of cows
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s != g) {
                if (map.containsKey(g)) {
                    numCows++;
                    // update the map
                    if (map.get(g) == 1) {
                        map.remove(g);
                    } else {
                        int freq = map.get(g);
                        freq--;
                        map.put(g, freq);
                    }
                }
            }
        }

        return numBulls + "A" + numCows + "B";
    }
}
