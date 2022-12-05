package com.leetcode;

public class LeetCode322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount ;i++){
            int min = Integer.MAX_VALUE;
            for(int j= 0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]] < min){
                    min = dp[i-coins[j]] + 1;
                }
            }
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
