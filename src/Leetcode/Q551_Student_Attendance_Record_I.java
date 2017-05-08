package Leetcode;

/**
 * Created by rbhatnagar2 on 5/6/17.
 */
public class Q551_Student_Attendance_Record_I {
    public boolean checkRecord(String s) {
        if (s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
}
