package com.leetcode.jianzhi;

import java.util.Stack;

public class jianzhi65_不用加减乘除做加法 {


    /**
     * 递归
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if (b == 0) return a;

        int res = a ^ b;   //无进位加法
        int up = (a & b) << 1;   //判断进位

        return add(res, up);
    }


    /**
     * 非递归
     * @param a
     * @param b
     * @return
     */
    public static  int add2(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位

        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add2(6,2));
    }
}
