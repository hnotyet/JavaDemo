package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LeetCode32 {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
                } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) return 0;

        Deque<Integer> deque = new ArrayDeque();

        int res = 0;
         deque.push(-1);

         for(int i = 0 ;i < s.length() ; i++){
             if(s.charAt(i) == '('){
                 deque.push(i);
             }else{
                 deque.pop();
                 if (deque.isEmpty()){
                     deque.push(i);}
                 else {
                     res = Math.max(res, i - deque.peek());
                 }
             }


         }


        return 0;
    }
}
