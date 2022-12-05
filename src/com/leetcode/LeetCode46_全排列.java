package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/23 全排列，回溯搜索，深度优先搜索
 */
public class LeetCode46_全排列 {

  public static List<List<Integer>> permute(int[] nums) {
    // 首先是特判
    int len = nums.length;
    // 使用一个动态数组保存所有可能的全排列
    List<List<Integer>> res = new ArrayList<>();

    if (len == 0) {
      return res;
    }

    boolean[] used = new boolean[len];
    List<Integer> path = new ArrayList<>();

    dfs(nums, len, 0, path, used, res);
    return res;
  }

  private static void dfs(int[] nums, int len, int depth,
      List<Integer> path, boolean[] used,
      List<List<Integer>> res) {
    if (depth == len) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < len; i++) {
      if (!used[i]) {
        path.add(nums[i]);
        used[i] = true;

        dfs(nums, len, depth + 1, path, used, res);
        // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
        used[i] = false;
        path.remove(path.size() - 1);
      }
    }
  }



}
