package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q401_Binary_Watch {
    Map<Integer, List<String>> minuteMap = new HashMap<Integer, List<String>>() {
        {
            put(0, new ArrayList<String>() {{
                add("00");
            }});
            put(1, new ArrayList<String>() {{
                add("01");
                add("02");
                add("04");
                add("08");
                add("16");
                add("32");
            }});
            put(2, new ArrayList<String>() {{
                add("03");
                add("05");
                add("06");
                add("09");
                add("10");
                add("12");
                add("17");
                add("18");
                add("20");
                add("24");
                add("33");
                add("34");
                add("36");
                add("40");
                add("48");
            }});
            put(3, new ArrayList<String>() {{
                add("07");
                add("11");
                add("13");
                add("14");
                add("19");
                add("21");
                add("22");
                add("25");
                add("26");
                add("28");
                add("35");
                add("37");
                add("38");
                add("41");
                add("42");
                add("44");
                add("49");
                add("50");
                add("52");
                add("56");
            }});
            put(4, new ArrayList<String>() {{
                add("15");
                add("23");
                add("27");
                add("29");
                add("30");
                add("39");
                add("43");
                add("45");
                add("46");
                add("51");
                add("53");
                add("54");
                add("57");
                add("58");
            }});
            put(5, new ArrayList<String>() {{
                add("31");
                add("47");
                add("55");
                add("59");
            }});
        }
    };
    Map<Integer, List<String>> hourMap = new HashMap<Integer, List<String>>() {
        {
            put(0, new ArrayList<String>() {{
                add("0");
            }});
            put(1, new ArrayList<String>() {{
                add("1");
                add("2");
                add("4");
                add("8");
            }});
            put(2, new ArrayList<String>() {{
                add("3");
                add("5");
                add("6");
                add("9");
                add("10");
            }});
            put(3, new ArrayList<String>() {{
                add("7");
                add("11");
            }});
        }
    };

    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i <= num; i++) {
            int hour = i;
            int minute = num - i;
            if (hour <= 3 && minute <= 5) {
                List<String> hours = hourMap.get(hour);
                List<String> minutes = minuteMap.get(minute);
                for (int j = 0; j < hours.size(); j++) {
                    for (int k = 0; k < minutes.size(); k++) {
                        ans.add(hours.get(j) + ":" + minutes.get(k));
                    }
                }
            }
        }
        return ans;
    }
}
