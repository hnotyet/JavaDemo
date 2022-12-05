package com.leetcode;

public class LeetCode200_岛屿数量 {


    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length ;i++){
            for(int j=0; j< grid[0].length ;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }

        }
        return count;
    }


    void dfs(char[][] grid,int i,int j){
        if(i<0 || i > grid.length-1 || j<0 || j > grid[0].length-1){
            return;
        }
        if(grid[i][j] != '1'){
            return ;
        }
        grid[i][j] = '2';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
