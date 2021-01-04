package com.design.singleton;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/4
 */
public class SingleTon {

  private static SingleTon singleTon = new SingleTon();
  private static volatile SingleTon singleTon2 = null;

  private SingleTon() {
  }

  public static SingleTon getInstance() {
    return singleTon;
  }

  public static SingleTon getInstance2() {
    if (singleTon2 == null) {
      synchronized (SingleTon.class) {
        if (singleTon2 == null) {
          singleTon2 = new SingleTon();
        }
      }
    }
    return singleTon2;
  }
}
