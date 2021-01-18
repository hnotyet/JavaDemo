package com.mutithread;

import java.util.concurrent.Semaphore;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/5
 */
public class SemaphoreTest {

  public static void main(String[] args) {
    MajusculeABC maj = new MajusculeABC();
    Thread t_a = new Thread(new Thread_ABC(maj, 'A'));
    Thread t_b = new Thread(new Thread_ABC(maj, 'B'));
    Thread t_c = new Thread(new Thread_ABC(maj, 'C'));
    t_a.start();
    t_b.start();
    t_c.start();
  }


  static class MajusculeABC {

    Semaphore semaphoreA = new Semaphore(1);
    Semaphore semaphoreB = new Semaphore(0);
    Semaphore semaphoreC = new Semaphore(0);


    public void printA() {
      try {
        semaphoreA.acquire();

        System.out.print('A');
        semaphoreB.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }


    public void printB() {
      try {
        semaphoreB.acquire();

        System.out.print('B');
        semaphoreC.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }


    public void printC() {
      try {
        semaphoreC.acquire();

        System.out.print('C');

        semaphoreA.release();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Thread_ABC implements Runnable {

    private MajusculeABC maj;
    private char name;

    public Thread_ABC(MajusculeABC maj, char name) {
      this.maj = maj;
      this.name = name;
    }

    public void run() {

      int c = 0;
      while (c < 20) {
        if (name == 'A') {
          maj.printA();
        }

        if (name == 'B') {
          maj.printB();
        }

        if (name == 'C') {
          maj.printC();
        }
        c++;
      }
    }

  }
}

