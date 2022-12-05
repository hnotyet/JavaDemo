package com.leetcode;


public class LeetCode279_完全平方数 {


    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int[] nums = new int[(int) Math.sqrt(n)];

        for (int i = 0; i <= n; i++) {
            dp[i] = i; // 先假设只有1来构成dp数组的每一个数，这也是最坏情况
        }


        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i + 1) * (i + 1); // 构建nums数组
        }


        for (int i = 1; i <= n; i++) {
            for (int num : nums) { //
                dp[i] = Math.min(dp[i], dp[i - num] + 1); // 注意这里，状态转移方程采用min方式
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        int[] dp = new int[n + 1];

      for (int i = 0; i <= n; i++) {
        dp[i] = i; // 先假设只有1来构成dp数组的每一个数，这也是最坏情况
      }

      int maxSqrt = (int)Math.sqrt(n);
      for(int i=1; i <=n; i++){
        for( int j=1 ; j <= maxSqrt ;i++){
          dp[i] = Math.min(dp[i],dp[i-j*j]+1);
        }
      }
      return dp[n];
    }


}


