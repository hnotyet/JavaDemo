package com.leetcode;

import com.leetcode.LeetCode101_对称二叉树.TreeNode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/20
 */
public class LeetCode104_二叉树最大深度 {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    return max;
  }
}
