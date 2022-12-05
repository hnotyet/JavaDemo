package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/17 最大子序和-动态规划
 */
public class LeetCode53_最大子数组和 {


  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
  }

  public static int maxSubArray(int[] nums) {

    int max = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > 0) {
        nums[i] += nums[i - 1];
      }

      max = Math.max(nums[i], max);
    }
    return max;
  }
}
