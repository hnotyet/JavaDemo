package com.leetcode;

import com.leetcode.LeetCode101_对称二叉树.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/20 二叉树的层次遍历
 */
public class LeetCode107 {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {

    List<List<Integer>> list = new ArrayList<>();
    int depth = 0;
    list = test(root, depth, list);

    List<List<Integer>> newlist = new ArrayList<>();

    for (int i = list.size()-1; i >=0 ; i--) {
      newlist.add(list.get(i));
    }

    return list;

  }

  public List<List<Integer>> test(TreeNode root, int depth, List<List<Integer>> list) {
    if (root == null) {
      return list;
    }

    List<Integer> deList = null;
    if (list.size() >= depth + 1) {
      deList = list.get(depth);
    } else {
      deList = new ArrayList<>();
      list.add(depth, deList);
    }

    deList.add(root.val);

    test(root.left, depth + 1, list);
    test(root.right, depth + 1, list);

    return list;
  }
}
