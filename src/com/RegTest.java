package com;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/14
 */
public class RegTest {


  public static void main(String[] args) {

    String content = "给这些邮箱做个加密，yest@163.com，ystttkl@163.com处理一下,还有ysttkl@ya-ho.com";

    Pattern pattern = Pattern.compile("[a-zA-Z_]+@(\\w|-)+\\.{1}[a-zA-Z_]+");

    Matcher matcher = pattern.matcher(content);

    System.out.println(matcher.find());

    System.out.println(matcher.group(1));

    System.out.println(matcher.replaceAll("****"));

    String reg = "/\\w+@\\w+.{1}\\w+";
    System.out.println(Pattern.matches(reg, content));



  }

  //Matcher matcher = Pattern.matches(reg,content);

//
}
