package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/17 外观数列
 */
public class LeetCode38 {


  public static void main(String[] args) {
    System.out.println(countAndSay(4));
  }

  static Map<Integer, String> map  = new HashMap<>();

  public static  String countAndSay(int n) {
    if (n == 1) {
      map.put(1,"1");
      return "1";
    }

    String s = map.get(n-1);
    if (s == null) {
      s = countAndSay(n - 1);
    }

    StringBuffer sb = new StringBuffer();
    char c = s.charAt(0);
    int num = 0;
    for (int i=0; i  < s.length() ;i++) {
      char ch= s.charAt(i);
      if (ch == c) {
        num++;
      } else {
        sb.append(num).append(c);
        c = ch;
        num = 1;
      }
      if (i == s.length() -1){
        sb.append(num).append(ch);
      }
    }

    map.put(n,sb.toString());
    return sb.toString();
  }
}
