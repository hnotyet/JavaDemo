package com.leetcode;

import com.leetcode.LeetCode21.Solution;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/19
 * 二进制和
 */
public class LeetCode67 {

  public static void main(String[] args) {
    System.out.println(addBinary2("11", "1"));
  }


  public String addBinary(String a, String b) {
    return Integer.toBinaryString(
        Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
    );
  }


  public static String addBinary2(String a, String b) {
    StringBuffer ans = new StringBuffer();

    int n = Math.max(a.length(), b.length()), carry = 0;
    for (int i = 0; i < n; ++i) {
      carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
      carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
      ans.append((char) (carry % 2 + '0'));
      carry /= 2;
    }

    if (carry > 0) {
      ans.append('1');
    }
    ans.reverse();

    return ans.toString();
  }
}
