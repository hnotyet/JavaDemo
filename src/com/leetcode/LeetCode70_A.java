package com.leetcode;

import com.leetcode.LeetCode21.Solution;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/19
 * 爬楼梯-动态规划 f(x)=f(x−1)+f(x−2)
 */
public class LeetCode70_A {

  public int climbStairs(int n) {
    int p = 0, q = 0, r = 1;
    for (int i = 1; i <= n; ++i) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }
}
