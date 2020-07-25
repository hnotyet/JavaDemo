package com.concur;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/13
 */
public class UnsafeTest {

  public static void main(String[] args) {

    Unsafe.getUnsafe();

    try {
      Field field = Unsafe.class.getDeclaredField("theUnsafe");
      field.setAccessible(true);
    } catch (NoSuchFieldException e) {

    }


  }
}
