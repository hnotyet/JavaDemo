package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/23 最长回文字串
 */
public class LeetCode5_最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        int length = s.length();
        boolean[][] d = new boolean[s.length()][s.length()];

        String ans = "";
        int maxLen = 0;

        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) {
                    break;
                }

                if ((len == 1 || len == 2 || d[start + 1][end - 1]) && (s.charAt(start) == s.charAt(end))) {
                    d[start][end] = true;
                    if (len > maxLen) {
                        maxLen = len;
                        ans = s.substring(start, end + 1);
                    }
                } else {
                    d[start][end] = false;
                }
            }
        }
        return ans;
    }

    public String longestPalindrome3(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;

                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            String temp1 = longestStr(s, i, i);
            String temp2 = longestStr(s, i, i + 1);

            String str = temp1.length() > temp2.length() ? temp1 : temp2;

            if (str.length() > res.length()) {
                res = str;
            }
        }
        return res;
    }


    private static String longestStr(String s, int l, int r) {
        int left = l;
        int right = r;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


}
