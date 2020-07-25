package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/20 对称二叉树-镜像对称
 */
public class LeetCode101 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  class Solution {

    public boolean isSymmetric(TreeNode root) {
      return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
        return true;
      }
      if (p == null || q == null) {
        return false;
      }
      return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
  }

}
