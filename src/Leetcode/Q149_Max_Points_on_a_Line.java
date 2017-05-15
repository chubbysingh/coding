package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q149_Max_Points_on_a_Line {
    private int gcd(int a, int b) {
        if ( a==0 ) return b;
        return gcd ( b%a, a );
    }

    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            Map<String, Integer> hm = new HashMap<>();
            int samex = 1;
            int samey = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i) {
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y))
                        samep++;
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    if(points[j].y == points[i].y) {
                        samey++;
                        continue;
                    }
                    int numerator = points[j].y - points[i].y;
                    int denaminator = points[j].x - points[i].x;
                    int gcd = gcd(numerator, denaminator);
                    String hashStr = (numerator/gcd) + "_" + (denaminator/gcd);
                    hm.put(hashStr,hm.getOrDefault(hashStr, 1) + 1);
                    result = Math.max(result, hm.get(hashStr) + samep);
                }
            }
            result = Math.max(result, Math.max(samex, samey));
        }
        return result;
    }

    public class Point {
        public int x;
        public int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
