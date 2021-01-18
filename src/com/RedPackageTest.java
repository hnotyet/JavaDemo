package com;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/5
 */
public class RedPackageTest {


  public static void main(String[] args) {
    for (long a : test(1000L, 5)) {
      System.out.println(a);
    }
  }

  public static Long[] test(Long amount, int number) {
    Long[] result = new Long[number];

    Long average = amount / number;

    int index = 0;
    long rest = amount;
    Random random = new Random();
    int c = 0;
    while (index < number - 1) {
      double rate = 2 * random.nextDouble();
      long r = new BigDecimal(rate).multiply(new BigDecimal(average)).longValue();
      System.out.println("r =" + r);
      if (r > 0 && r < rest) {
        result[index] = r;
        rest = rest - r;
        index++;
      }
//      System.out.println("run times =" + (++c));
    }
    result[index] = rest;

    return result;
  }
}
