package com.leetcode;

public class LeetCode371_两整数之和 {
    public int getSum(int a, int b) {
        if(b == 0) return a;

        int res = a ^ b;   //无进位加法
        int up = (a & b) << 1;   //判断进位

        return getSum(res,up);
    }

}
