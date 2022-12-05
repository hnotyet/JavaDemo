package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15_三数之和 {
    public static void main(String[] args) {


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <  3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int first =0 ; first< nums.length ; first++){
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = nums.length-1;
            for (int second = first + 1; second < nums.length ;second ++){

                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }

                if(second == third){
                    break;
                }

                if(nums[first] + nums[second] + nums[third] == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);

                }
            }
        }
       return ans;
    }
}
