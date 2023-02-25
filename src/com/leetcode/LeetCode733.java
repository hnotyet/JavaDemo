package com.leetcode;

public class LeetCode733 {

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        if(image != null || image.length == 0){
            return image;
        }

        dfs(image,sr,sc,newColor,image[sr][sc]);

        return image;
    }

    void dfs(int[][] image, int sr, int sc, int newColor,int oldColor){
        if(sr < 0 || sr <0  || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor || oldColor == newColor){
            return;
        }


        image[sr][sc] = oldColor;

        dfs(image,sr-1,sc,newColor,oldColor);
        dfs(image,sr+1,sc,newColor,oldColor);
        dfs(image,sr,sc-1,newColor,oldColor);
        dfs(image,sr,sc+1,newColor,oldColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        helper(image, sr, sc, newColor, image[sr][sc]);

        return image;

    }

    void helper(int[][] image, int sr, int sc, int newColor, int oldColor) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != oldColor || newColor == oldColor){
            return;
        }

        image[sr][sc] = newColor;

        helper(image, sr - 1, sc, newColor, oldColor);
        helper(image, sr + 1, sc, newColor, oldColor);
        helper(image, sr, sc - 1, newColor, oldColor);
        helper(image, sr, sc + 1, newColor, oldColor);

    }

}
