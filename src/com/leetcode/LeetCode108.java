package com.leetcode;


import com.leetcode.model.TreeNode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/20
 */
public class LeetCode108 {

  public TreeNode sortedArrayToBST(int[] nums) {

    return createNode(nums, 0, nums.length - 1);
  }


  private TreeNode createNode(int[] nums, int left, int right) {

    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = createNode(nums, left, mid - 1);
    node.right = createNode(nums, mid + 1, right);

    return node;
  }
}
