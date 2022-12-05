package com.leetcode;

public class LeetCode190_颠倒二进制位 {

    // you need treat n as an unsigned value
        public static int  reverseBits(int n) {
            int rev = 0;
            for (int i = 0; i < 32 && n != 0; ++i) {
                rev |= (n & 1) << (31 - i);
                System.out.println(rev);
                n >>>= 1;
            }
            return rev;
        }


    public static void main(String[] args) {
        System.out.println(reverseBits(5));
    }
}
