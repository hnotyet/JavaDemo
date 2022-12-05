package com.leetcode;


import java.util.HashSet;
import java.util.Set;

public class LeetCode70 {

    public int climbStairs(int n) {
      int[] dp = new int[n];
      for(int i=1;i<=n;i++){
          if(i==1){
              dp[i] = 1;
          }else if(i==2){
              dp[1]= 2;
          }else{
              dp[i] = dp[i-2]+dp[i-1];
          }
      }
      return dp[n-1];
    }
}
