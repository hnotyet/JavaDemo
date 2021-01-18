package com.mutithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/5
 */
public class LockConditionTest {

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

    Lock lock = new ReentrantLock();
    Condition aCon = lock.newCondition();
    Condition bCon = lock.newCondition();
    Condition cCon = lock.newCondition();

    volatile char state = 'A';

    public void printA(){
      try{
        lock.lock();

        while(state != 'A'){
          try {
            aCon.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        System.out.print('A');
        state = 'B';
        bCon.signal();
      }finally {
        lock.unlock();
      }
    }


    public void printB(){
      try{
        lock.lock();

        while(state != 'B'){
          try {
            bCon.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        System.out.print('B');
        state = 'C';
        cCon.signal();
      }finally {
        lock.unlock();
      }
    }


    public void printC(){
      try{
        lock.lock();

        while(state != 'C'){
          try {
            cCon.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        System.out.print('C');
        state = 'A';
        aCon.signal();
      }finally {
        lock.unlock();
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

      int c= 0;
      while(c<20){
        if(name == 'A'){
          maj.printA();
        }

        if(name == 'B'){
          maj.printB();
        }

        if(name == 'C'){
          maj.printC();
        }
        c++;
      }
    }

  }
}
