package com.leetcode;

public class LeetCode231_2的幂 {


    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (n - 1)) == 0;
    }
}
