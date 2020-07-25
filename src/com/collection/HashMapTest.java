package com.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/8
 */
public class HashMapTest {

  public static void main(String[] args) {

    Map map = new HashMap(100,1f);


    int cap = 8;
    int n = cap - 1;
      n |= n >>> 1;
      n |= n >>> 2;
      n |= n >>> 4;
      n |= n >>> 8;
      n |= n >>> 16;
     // n = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;


      System.out.println(n);

    }


}
