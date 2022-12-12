package com.leetcode;

import java.util.List;

public class LeetCode120_三角形最小路径和 {


    Integer[][] memo = null;
    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return  min(triangle,0,0);
    }

    public int min(List<List<Integer>> triangle,int depth,int index){
        if(depth == triangle.size()){
            return 0;
        }
        if (memo[depth][index] != null) {
            return memo[depth][index];
        }
        return memo[depth][index] = Math.min(min(triangle,depth+1,index),min(triangle,depth+1,index+1)) +triangle.get(depth).get(index) ;
    }
}
