package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/18
 */
public class Test {

  public static void main(String[] args) {
    System.out.println(longestChildStr("abcde", "abgde"));

  }

  public static int longestChildStr(String text1, String text2) {
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    int dp[][] = new int[s1.length][s2.length];

    for (int i = 0; i < s1.length; i++) {
      if (s2[0] == s1[i]) {
        dp[i][0] = 1;
      } else {
        dp[i][0] = 0;
      }
    }

    for (int j = 0; j < s2.length; j++) {
      if (s1[0] == s2[j]) {
        dp[0][j] = 1;
      } else {
        dp[0][j] = 0;
      }
    }

    for (int i = 0; i < s1.length; i++) {
      for (int j = 0; j < s2.length; j++) {
        if (s1[i] == s2[j]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = 0;
        }
      }
    }

    int max = dp[0][0];

    for (int i = 0; i < s1.length; i++) {
      for (int j = 0; j < s2.length; j++) {
        max = Math.max(max, dp[i][j]);
      }
    }
    return max;
  }


}
