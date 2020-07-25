package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/23 最长回文字串
 */
public class LeetCode5_A {

  public static void main(String[] args) {
    System.out.println(longestPalindrome("cbbd"));
  }


  public static String longestPalindrome(String s) {
    char[] chars = s.toCharArray();
    String res = "";
    for (int i = 0; i < chars.length; i++) {
      String temp1 = longestStr(s, i, i);
      String temp2 = longestStr(s, i, i + 1);

      String str = temp1.length() > temp2.length() ? temp1 : temp2;

      if (str.length() > res.length()) {
        res = str;
      }
    }
    return res;
  }


  private static String longestStr(String s, int l, int r) {
    int left = l;
    int right = r;

    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }
      left--;
      right++;
    }
    return s.substring(left + 1,right);
  }
}
