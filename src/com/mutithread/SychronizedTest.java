package com.mutithread;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/5
 */
public class SychronizedTest {

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

    volatile char state = 'A';

    public void printA() {

      synchronized (this) {
        while (state != 'A') {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.print('A');
        state = 'B';
        notifyAll();
      }
    }


    public void printB() {
      synchronized (this) {
        while (state != 'B') {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.print('B');
        state = 'C';
        notifyAll();

      }
    }

    public void printC() {
      synchronized (this) {
        while (state != 'C') {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        System.out.print('C');
        state = 'A';
        notifyAll();
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
