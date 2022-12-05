package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/19
 * 求平方根的整数部分
 *
 */
public class LeetCode69 {

  public int mySqrt(int x) {
    int l = 0, r = x, ans = -1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if ((long) mid * mid <= x) {
        ans = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return ans;
  }

}
