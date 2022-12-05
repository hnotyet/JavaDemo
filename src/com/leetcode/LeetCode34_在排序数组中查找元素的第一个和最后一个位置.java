package com.leetcode;

public class LeetCode34_在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len==0){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2 ;


            if(nums[mid] > target){
               right = mid-1;

            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                if(nums[left] != target){
                    left++;
                }else if(nums[right] != target){
                    right--;
                }else{
                    break;
                }
            }
        }
        if(left <= right) {
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;//left 和 right 所代表的区间，包含了所有 target
        while(left <= right) {// 可能存在没有 target 的情况
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;// mid 及其之前的元素不可能是 target，left = mid + 1 进一步缩减区间
            } else if(nums[mid] > target) {
                right = mid - 1;// mid 及其之后的元素不可能是 target，right = mid - 1 进一步缩减区间
            } else {
                if(nums[left] != target) {//判断 left 是否为 target，如果不是则进一缩减区间
                    left++;
                } else if(nums[right] != target) {//判断 right 是否为 target，如果不是则进一步缩减区间
                    right--;
                } else {//区间不再可缩，结束。left 为第一个 target，right 为最后一个 target
                    break;
                }
            }
        }

        if(left <= right) {
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }

}
