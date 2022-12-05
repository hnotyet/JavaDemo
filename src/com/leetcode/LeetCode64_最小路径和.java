package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/23 最小路径和
 */
public class LeetCode64_最小路径和 {

  public int minPathSum(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int min = grid[0][0];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {

        if (i > 0 && j > 0) {
          int left = grid[i][j - 1];
          int up = grid[i - 1][j];

          min = Math.min(left, up) + grid[i][j];

          grid[i][j] = min;

        } else if (i > 0) {
          int up = grid[i - 1][j];
          min = up + grid[i][j];
          grid[i][j] = min;

        } else if (j > 0) {
          int left = grid[i][j - 1];
          min = left + grid[i][j];
          grid[i][j] = min;
        }
      }
    }
    return min;
  }
}
