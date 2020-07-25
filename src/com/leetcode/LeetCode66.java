package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/19
 */
public class LeetCode66 {


  public static void main(String[] args) {
    System.out.println(plusOne(new int[]{9,9}));
  }

  public static  int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] = digits[i] % 10;
      if (digits[i] != 0) {
        return digits;
      }
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }

}
