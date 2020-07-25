package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/23 搜索二维矩阵
 */
public class LeetCode74 {




  public static void main(String[] args) {
    int[][] a = {{1},{3}};

    System.out.println(searchMatrix(a,3));
  }

  public static  boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length ==0){
      return false;
    }

    int columns = matrix[0].length;
    for (int i = 0; i < matrix.length; i++) {
      int first = matrix[i][0];
      int end = matrix[i][columns - 1];
      if (target == first || target == end) {
        return true;
      } else if (target > first && target < end) {
        int[] rows = matrix[i];
        for (int t : rows) {
          if (t == target) {
            return true;
          }
        }
      } else {
        continue;
      }
    }
    return false;
  }
}
