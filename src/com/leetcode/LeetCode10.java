package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/6/19
 */
public class LeetCode10 {


  public static void main(String[] args) {

    String s = "aa";
    String p = ".*";

    System.out.println(isMatch(s, p));
  }

  public static boolean isMatch(String s, String p) {

    int index_p = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if(index_p >= p.length()){
        return false;
      }

      char char_p = p.charAt(index_p);

      if (char_p != '.' && char_p != '*') {
        if (c != char_p) {
          return false;
        }
        index_p++;
      } else {
        if (char_p == '.') {
          index_p++;
        } else {

          char char_c = p.charAt(index_p - 1);
          if (c != char_c) {
            if (char_c == '.'){
              continue;
            }

            if (index_p + 1 < p.length()) {
              char char_next = p.charAt(index_p + 1);
              if (c == char_next) {
                index_p++;
                continue;
              } else {
                return false;
              }
            } else {
              return false;
            }
          }
        }
      }
    }

    if (index_p < s.length() - 1) {
      return false;
    }
    return true;
  }
}
