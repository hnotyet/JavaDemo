package com.leetcode;

public class LeetCode11_盛最多水的容器 {

    public static void main(String[] args) {
    }


    /**
     * 双指针法
     * @param height
     * @return
     */
    public static int maxArea2(int[] height){

        int i = 0;
        int j = height.length-1 ;
        int max = Math.min(height[i],height[j]) * (j-i);
        while(i < j ){
            if(height[i] < height[j]){
                max =  Math.max(max,height[i] * (j-i));
                i++;
            }else{
                max =  Math.max(max,height[j] * (j-i));
                j--;
            }

        }
        return max;

    }
}
