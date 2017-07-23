package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 7/23/17.
 */
public class Test


    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        // RETURN AN EMPTY MATRIX IF PREFERRED LUNCH IS NOT FOUND
        public String[][] matchLunches(String[][] lunchMenuPairs,
                                       String[][] teamCuisinePreference)
        {
            List<String[]> res = new LinkedList<String[]>();
            if (lunchMenuPairs == null || teamCuisinePreference == null)
                return null;

            Map<String, List<String>> cuisineMap = generateMap(lunchMenuPairs);

            for (String[] pref : teamCuisinePreference) {
                String member = pref[0];
                String cruisine = pref[1];

                if (cruisine.equals("*")) {
                    for (String key : cuisineMap.keySet()) {
                        addCruisine(res, member, cuisineMap, key);
                    }
                } else {
                    addCruisine(res, member, cuisineMap, cruisine);
                }

            }

            String[][] resultStr = new String[res.size()][2];
            int index = 0;
            for (String[] strArr : res) {
                resultStr[index][0] = strArr[0];
                resultStr[index][1] = strArr[1];
                index++;
            }
            return resultStr;

        }

        private Map<String, List<String>> generateMap(String[][] lunchMenuPairs) {
            Map<String, List<String>> cuisineMap = new HashMap<String, List<String>>();

            for (String[] pair : lunchMenuPairs) {
                String dish = pair[0];
                String cruisine = pair[1];

                if(!cuisineMap.containsKey(cruisine)) {
                    List<String> list = new LinkedList<String>();
                    cuisineMap.put(cruisine, list);
                }
                cuisineMap.get(cruisine).add(dish);

            }
            return cuisineMap;
        }

        private void addCruisine(List<String[]> res, String member,
                                 Map<String, List<String>> cruisineMap,
                                 String cruisine) {

            if (cruisineMap.containsKey(cruisine)) {
                List<String> dishes = cruisineMap.get(cruisine);
                for (String dish : dishes) {
                    res.add(new String[] {member, dish});
                }
            }
        }
        // METHOD SIGNATURE ENDS

        public static void main(String[] args) {
            Test sol = new Test();
            String[][] lunchMenuPairs = {
                    {"taco", "mexican"},
                    {"torta", "mexican"}
            };
            String[][] teamCuisinePreference = {
                    {"iam", "*"}
            };

            String[][] res = sol.matchLunches(lunchMenuPairs, teamCuisinePreference);
            for (String[] s : res)
                System.out.println(s[0] + " " + s[1]);
        }
    }


