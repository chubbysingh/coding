package com.whitespace.raghav.Strings;

/**
 * Created by rbhatnagar2 on 9/22/15.
 */
public class PatternMatching {

    private static boolean isMatch(String sourceStr, String patternString) {
        if (sourceStr == null && patternString == null)
            return false;
        if (patternString.equals("*")) {
            return true;
        }

        int sourceLength = sourceStr.length(),
            patternLength = patternString.length();
        return isMatch(sourceStr, patternString, sourceLength-1, patternLength-1);
    }

    private static boolean isMatch
            (String sourceStr, String patternString, int sourceIndex, int patternIndex) {

        if (sourceIndex < 0 && patternIndex < 0)
            return true;
        else if (patternIndex < 0)
            return false;

        else if (sourceIndex < 0) {
            while (patternIndex >=0) {
                if (patternString.charAt(patternIndex) == '*') {
                    patternIndex -= 2;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            if (sourceStr.charAt(sourceIndex) == patternString.charAt(patternIndex)) {
                return isMatch(sourceStr, patternString, --sourceIndex, --patternIndex );
            } else if (patternString.charAt(patternIndex) == '*') {
                if (patternIndex > 0 && sourceStr.charAt(sourceIndex) == patternString.charAt(patternIndex-1))
                    return isMatch(sourceStr, patternString, sourceIndex-1, patternIndex);
                else
                    return isMatch(sourceStr, patternString, sourceIndex, patternIndex-2);
            } else {
                if (patternIndex < patternString.length() - 1
                        && sourceStr.charAt(sourceIndex) == patternString.charAt(patternIndex+2)
                        && patternString.charAt(patternIndex+1) == '*')
                    return isMatch(sourceStr, patternString, sourceIndex-1, patternIndex);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("a", "b*a"));
        System.out.println(isMatch("a", "a*a"));
        System.out.println(isMatch("a", "aa*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ccccccaaab", "c*a*b"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a"));
    }
}
