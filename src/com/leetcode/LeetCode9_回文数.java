package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/6/19
 */
public class LeetCode9_回文数 {

  public static void main(String[] args) {
    System.out.println(isPalindrome(-121));
  }

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    if (x == 0) {
      return true;
    }

    List<Integer> lst = new ArrayList<Integer>();

    while (x > 0) {
      int mod = x % 10;
      lst.add(mod);
      x = x / 10;
    }

    int left = 0;
    int right = lst.size() - 1;

    while (left <= right) {
      if (lst.get(left) != lst.get(right)) {
        return false;
      }

      left++;
      right--;
    }
    return true;
  }
}
