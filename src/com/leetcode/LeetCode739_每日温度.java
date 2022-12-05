package com.leetcode;

import java.util.Stack;

public class LeetCode739_每日温度 {

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            boolean flag = false;
            for(int j=i+1;j<temperatures.length;j++){
             if(temperatures[j]>temperatures[i]){
               res[i]=j-i;
               flag = true;
               break;
             }
            }

            if(!flag){
                res[i]=0;
            }
        }


        return res;
    }


    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.add(i);

        }
        return result;
    }

}
