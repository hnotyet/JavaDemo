package com;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/4
 */
public class ThreadJoin {


  public static void main(String[] args) {
    Thread thread = new Thread();

    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }
}
