package com.leetcode;

public class LeetCode300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;

        for(int d =0;d<dp.length;d++){
            dp[d] = 1;
        }

        for(int i=1;i<nums.length ;i++){
            for(int j = i ; j >=0 ;j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
