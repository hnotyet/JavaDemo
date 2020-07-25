package com.collection;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/8
 */
public class MapTest {

  public static void main(String[] args) {
    int cap = 29;
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    // n = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;


    System.out.println(29>>>16);
    System.out.println(29>>16);
    System.out.println(n);

    String s = "acbsdfsd";
    int h = 0;
    System.out.println(h = s.hashCode());
    System.out.println(h = s.hashCode() ^ (h >>> 16));
    System.out.println(h >>> 16);
    System.out.println(Math.pow(2,16));
  }
}
