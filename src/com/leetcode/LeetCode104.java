package com.leetcode;

import com.leetcode.LeetCode101.TreeNode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/20
 */
public class LeetCode104 {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    return max;
  }
}
