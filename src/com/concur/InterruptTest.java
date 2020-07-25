package com.concur;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/5
 */
public class InterruptTest {

  public static void main(String[] args) {

    Thread thread = new Thread();

    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
