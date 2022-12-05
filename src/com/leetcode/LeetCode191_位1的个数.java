package com.leetcode;

public class LeetCode191_位1的个数 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if( (n & 1) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
