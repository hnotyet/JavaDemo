package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/8 二叉树所有路径-深度优先搜索
 */
public class LeetCode257 {

  class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
      List<String> paths = new ArrayList<String>();
      constructPaths(root, "", paths);
      return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
      if (root != null) {
        StringBuffer pathSB = new StringBuffer(path);
        pathSB.append(root.val);
        if (root.left == null && root.right == null) {  // 当前节点是叶子节点
          paths.add(pathSB.toString());  // 把路径加入到答案中
        } else {
          pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
          constructPaths(root.left, pathSB.toString(), paths);
          constructPaths(root.right, pathSB.toString(), paths);
        }
      }
    }
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}


