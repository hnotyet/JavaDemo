package com.leetcode;

public class LeetCode560_和为K的子数组 {

    public int subarraySum(int[] nums, int k) {
        int[][] dp = new int[nums.length][nums.length];

        int count=0;
        for(int i=0; i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(j ==0){
                    dp[0][0] = nums[0];
                }else {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
                if(dp[i][j] == k){
                    count++;
                }
            }
        }
        return count;
    }


    public class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for (int start = 0; start < nums.length; ++start) {
                int sum = 0;
                for (int end = start; end >= 0; --end) {
                    sum += nums[end];
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

}
