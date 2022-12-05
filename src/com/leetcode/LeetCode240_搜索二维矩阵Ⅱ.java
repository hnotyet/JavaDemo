package com.leetcode;

public class LeetCode240_搜索二维矩阵Ⅱ {


    public boolean searchMatrix(int[][] matrix, int target) {

        for(int i =0 ;i < matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                if(matrix[i][j] == target){
                    return true;

                }else if(matrix[i][j] > target && matrix[i][j-1] < target && j>0){
                    break;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }



}
