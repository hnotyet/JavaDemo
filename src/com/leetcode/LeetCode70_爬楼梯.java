package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/19
 * 爬楼梯-动态规划 f(x)=f(x−1)+f(x−2)
 */
public class LeetCode70_爬楼梯 {

  public int climbStairs(int n) {
    int[] dp = new int[n+1];
    for(int i=1;i<=n;i++){
      if(i==1){
        dp[1] = 1;
      }else if(i==2){
        dp[2]= 2;
      }else{
        dp[i] = dp[i-2]+dp[i-1];
      }
    }
    return dp[n];
  }
}
