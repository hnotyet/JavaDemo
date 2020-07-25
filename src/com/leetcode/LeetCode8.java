package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/6/19
 */

/**
 * 字符串转换整数
 */
public class LeetCode8 {

  public static void main(String[] args) {
    System.out.println(myAtoi("+1"));

    System.out.println("-12345".charAt(5)-'0');

    System.out.println('0');
  }

  public static int myAtoi(String str) {
    StringBuffer buffer = new StringBuffer();
    for (char c : str.toCharArray()) {
      if (buffer.length() == 0 && c == ' ') {
        continue;
      }
      if (buffer.length() == 0 && c == '-') {
        buffer.append(c);
        continue;
      }
      if (buffer.length() == 0 && c == '+') {
        continue;
      }

      if (buffer.length() >= 0 && !Character.isDigit(c)) {
        break;
      }
      buffer.append(c);
    }
    if (buffer.length() > 0) {
      if (buffer.length() == 1 && buffer.charAt(0) == '-') {
        return 0;
      }

      if (buffer.charAt(0) == '-') {
        int res = 0;
        for (int i = 1; i < buffer.length(); i++) {

          if (-res < Integer.MIN_VALUE / 10) {
            return Integer.MIN_VALUE;
          }
          res = res * 10 + Character.getNumericValue(buffer.charAt(i));
        }
        return -res;
      } else {
        int res = 0;
        for (int i = 0; i < buffer.length(); i++) {

          if (res > Integer.MAX_VALUE / 10) {
            return Integer.MAX_VALUE;
          }
          res = res * 10 + Character.getNumericValue(buffer.charAt(i));
        }
        return res;
      }
    }
    return 0;
  }
}
