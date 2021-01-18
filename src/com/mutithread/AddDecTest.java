package com.mutithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/5
 */
public class AddDecTest {


  public static void main(String[] args) {

    Parameter parameter = new Parameter();

    Thread addThread = new WrapperThread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100; i++) {
          try {
            parameter.lock.lock();

            parameter.count++;
            System.out.println(parameter.count);
          } finally {
            parameter.lock.unlock();
          }
        }
      }
    }, parameter);

    Thread decThread = new WrapperThread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100; i++) {
          try {
            parameter.lock.lock();

            parameter.count--;
            System.out.println(parameter.count);
          } finally {
            parameter.lock.unlock();
          }
        }

      }
    }, parameter);

    addThread.start();
    decThread.start();

    try {
      decThread.join();
      addThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.print(parameter.count);
  }

  static class Parameter {

    volatile int count = 0;
    Lock lock = new ReentrantLock();
  }

  static class WrapperThread extends Thread {

    private Parameter parameter;

    public WrapperThread(Runnable runnable, Parameter parameter) {
      super(runnable);
      this.parameter = parameter;
    }

  }
}
