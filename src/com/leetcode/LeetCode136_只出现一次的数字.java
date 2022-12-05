package com.leetcode;

public class LeetCode136_只出现一次的数字 {

    public int singleNumber(int[] nums) {

        int single = 0;
        for(int num:nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {


        System.out.println(1^2^2);
    }
}
