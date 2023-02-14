package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2_两数相加 {

    public int uniquePaths(int m, int n) {
        Set<String> res = new HashSet<>();
        int len = m + n - 2;
        str(len, 0, res, new StringBuffer(), m - 1, n - 1);
        return res.size();
    }

    public void str(int len, int depth, Set<String> res, StringBuffer buffer, int mrest, int nrest) {
        if (depth == len) {
            res.add(buffer.toString());
        }

        if (mrest > 0) {
            buffer.append(1);
            str(len, depth + 1, res, buffer, mrest - 1, nrest);
            buffer.deleteCharAt(buffer.length() - 1);
        }

        if (nrest > 0) {
            buffer.append(0);
            str(len, depth + 1, res, buffer, mrest, nrest - 1);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }


    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }
}
