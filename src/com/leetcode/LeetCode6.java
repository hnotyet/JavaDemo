package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/6/19
 */
public class LeetCode6 {

  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING", 3));
  }

  public static String convert(String s, int numRows) {
    if (numRows <= 1) {
      return s;
    }
    StringBuffer[] arr = new StringBuffer[numRows];
    for (int i = 0; i < numRows; i++) {
      arr[i] = new StringBuffer();
    }

    int flag = -1;
    int row = 0;
    for (char c : s.toCharArray()) {
      arr[row].append(c);

      if (row == 0 || row == numRows - 1) {
        flag = -flag;
      }
      row += flag;
    }

    StringBuffer buffer = new StringBuffer();
    for (StringBuffer b : arr) {
      buffer.append(b);
    }
    return buffer.toString();
  }
}
