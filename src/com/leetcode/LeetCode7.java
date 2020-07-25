package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/6/19
 */

/**
 * 整数反转
 */
public class LeetCode7 {


  public static void main(String[] args) {
    System.out.println(reverse(-123));
  }

  public static int reverse(int x) {
    int res = 0;
    int loop = x;
    while (loop != 0) {
      int m = loop % 10;

      if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && m > 7)) {
        return 0;
      }
      if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && m < -8)) {
        return 0;
      }

      res = res * 10 + m;
      loop = loop / 10;
    }
    return res;
  }

}
