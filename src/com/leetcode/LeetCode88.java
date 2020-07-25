package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/20
 */
public class LeetCode88 {


  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // two get pointers for nums1 and nums2
    int p1 = m - 1;
    int p2 = n - 1;
    // set pointer for nums1
    int p = m + n - 1;

    // while there are still elements to compare
    while ((p1 >= 0) && (p2 >= 0))
    // compare two elements from nums1 and nums2
    // and add the largest one in nums1
    {
      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
    }

    // add missing elements from nums2
    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
  }


  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    int l = m + n - 1;

    int l1 = m - 1;
    int l2 = n - 1;
    while (l >= 0) {

      if (l1 >= 0 && l2 >= 0) {
        if (nums1[l1] > nums2[l2]) {
          nums1[l] = nums1[l1];
          l--;
          l1--;
        } else {
          nums1[l] = nums2[l2];
          l--;
          l2--;
        }
      } else if (l1 >= 0) {
        nums1[l] = nums1[l1];
        l--;
        l1--;
      } else if (l2 >= 0) {
        nums1[l] = nums2[l2];
        l--;
        l2--;
      }
    }
  }
}
