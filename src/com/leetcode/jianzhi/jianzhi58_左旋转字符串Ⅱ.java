package com.leetcode.jianzhi;

public class jianzhi58_左旋转字符串Ⅱ {


    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
