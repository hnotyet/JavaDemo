package com.leetcode;

import java.util.Arrays;

public class LeetCode283_移动零 {

    public static void moveZeroes(int[] nums) {

        int j=0;
        for(int i =0 ;i < nums.length;i++){
            if(nums[i] !=0){
                int tmp = nums[i];
                nums[i] = 0;
                nums[j++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,2,0,3,0,4,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
