package com.leetcode;

public class LeetCode647_回文字串 {


    public static int countSubstrings(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<=i; j++) {

                if(s.charAt(i)==s.charAt(j)&&(i-j<=1||dp[i-1][j+1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }

}
