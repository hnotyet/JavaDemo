package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 */
public class LeetCode20_有效的括号 {

  public static void main(String[] args) {

    System.out.println(isValid2("()"));

  }

  public boolean isValid3(String s) {
    if(s.isEmpty())
      return true;
    Stack<Character> stack=new Stack<Character>();
    for(char c:s.toCharArray()){
      if(c=='(')
        stack.push(')');
      else if(c=='{')
        stack.push('}');
      else if(c=='[')
        stack.push(']');
      else if(stack.empty()||c!=stack.pop())
        return false;
    }
    if(stack.empty())
      return true;
    return false;
  }


  public LeetCode20_有效的括号() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  private HashMap<Character, Character> mappings;
  public boolean isValid(String s) {

    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (this.mappings.containsKey(c)) {
        char topElement = stack.empty() ? '#' : stack.pop();
        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }


  public static boolean isValid2(String s) {
    if (s == null || s.length() % 2 != 0) {
      return false;
    }
    if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
      return isValid2(s.replace("()", "").replace("[]", "").replace("{}", ""));
    } else {
      return "".equals(s);
    }
  }




}
