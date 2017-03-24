package com.whitespace.raghav.Misc;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/23/17.
 * Given input which is a vector of (user name, log-in time, log-out time), output time series which will have number of users logged in at each given time slot in the input,
 output should only contain time slots which are given in input for example if the input is
 "September", 1.2, 4.5),
 ("June", 3.1, 6.7),
 ("August", 8.9, 10.3)

 output should contain only 1.2, 3.1, 4.5, 3.1, 6.7, 8.9, 10.3

 Example:
 /*
 [
 ("September", 1.2, 4.5),
 ("June", 3.1, 6.7),
 ("August", 8.9, 10.3)
 ]

 =>

 [(1.2, 1), (3.1, 2), (4.5, 1), (6.7, 0), (8.9, 1), (10.3, 0)]
*
 */
public class LoginLogout {

    private static void printDetails(List<UserDetails> list) {
        List<TimeType> timeTypes = getList(list);

        Collections.sort(timeTypes, new Comparator<TimeType>() {
            @Override
            public int compare(TimeType o1, TimeType o2) {
                return o1.time > o2.time ? 1 : -1;
            }
        });

        int currentCount = 0;

        for (TimeType timeType : timeTypes) {
            if (timeType.isLogin)
                currentCount++;
            else
                currentCount--;

            System.out.println(timeType.time + "," + currentCount);

        }

    }

    private static List<TimeType> getList(List<UserDetails> list) {
        List<TimeType> timeTypes = new LinkedList<TimeType>();

        for (UserDetails userDetails : list) {
            timeTypes.add(new TimeType(userDetails.loginTime, true) );
            timeTypes.add(new TimeType(userDetails.logOutTime, false) );
        }
        return timeTypes;
    }


    public static void main(String[] args) {
        List<UserDetails> inputList = new LinkedList<UserDetails>();
        inputList.add(new UserDetails("September", 1.2, 4.5));
        inputList.add(new UserDetails("June", 3.1, 6.7));
        inputList.add(new UserDetails("August", 8.9, 10.3));

        printDetails(inputList);
    }
}

class UserDetails {
    String name;
    double loginTime;
    double logOutTime;

    public UserDetails(String name, double loginTime, double logOutTime) {
        this.name = name;
        this.loginTime = loginTime;
        this.logOutTime = logOutTime;
    }
}

class TimeType {
    double time;
    boolean isLogin;

    public TimeType(double time, boolean isLogin) {
        this.time = time;
        this.isLogin = isLogin;
    }
}