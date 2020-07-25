package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/17
 * 删除数组重复项
 */
public class LeetCode26 {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

}
