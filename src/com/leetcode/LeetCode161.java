package com.leetcode;

public class LeetCode161 {


    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    /**
     * 暴力
     * @param prices
     * @return
     */
    public  int maxProfit2(int[] prices) {
        int res = 0;
        for (int l = 0; l < prices.length; l++) {
            for (int r = l + 1; r < prices.length; r++) {
                    res = Math.max(res,prices[r]-prices[l]);
            }
        }
        return res;
    }

}
