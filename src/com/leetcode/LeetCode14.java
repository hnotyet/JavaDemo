package com.leetcode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/14
 */
public class LeetCode14 {



  public static void main(String[] args) {

    String[] strs = {"abc","abcdefg","abcdefghjkl"};

    System.out.println(longestCommonPrefix(strs));


  }


  public static String longestCommonPrefix(String[] strs) {
    StringBuffer sb = new StringBuffer();

    if(strs == null || strs.length == 0){
      return "";
    }

    String str = strs[0];

    boolean flag = true;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      for (String s : strs) {
        if (i >= s.length() || c != s.charAt(i)) {
          flag = false;
          break;
        }
      }
      if (!flag) {
        break;
      }
      sb.append(c);
    }
    return sb.toString();
  }
}
