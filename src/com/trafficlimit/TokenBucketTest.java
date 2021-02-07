package com.trafficlimit;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/16
 */
public class TokenBucketTest {

  /**
   * 定义了桶
   */
  static class Bucket {

    //容量
    private int capacity;
    //速率，每秒放多少
    private int rateCount;
    //目前token个数
    private volatile AtomicInteger curCount = new AtomicInteger(0);

//    private ReentrantLock lock = new ReentrantLock();
    private ScheduledThreadPoolExecutor scheduledCheck = new ScheduledThreadPoolExecutor(1);


    public Bucket(int capacity, int rateCount) {
      this.capacity = capacity;
      this.rateCount = rateCount;

      Runnable runnable = new Runnable() {
        @Override
        public void run() {
          put();
        }
      };

      scheduledCheck.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);

    }

    private void put() {
      System.out.println(Thread.currentThread().getName() + "====== put之前的数量：" + curCount.get());

      synchronized (curCount) {
        if (curCount.get() < capacity) {
          System.out.println("目前数量==" + curCount.get() + ", 我还可以继续放");
          if (curCount.addAndGet(rateCount) > capacity) {
            curCount.set(capacity);
          }
        }
      }
    }

    public boolean get() {
      System.out.println(Thread.currentThread().getName() + "====== get之前的数量：" + curCount.get());
      synchronized (curCount) {
        if (curCount.get() >= 1) {
          curCount.decrementAndGet();
          if (curCount.decrementAndGet() < 0) {
            curCount.set(0);
          }
          return true;
        }
      }
      return false;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Bucket bucket = new Bucket(5, 2);

    //先等待一会儿，让桶里放点token
    Thread.sleep(6000);

    //模拟瞬间10个线程进来拿token
    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        if (bucket.get()) {
          System.out.println(Thread.currentThread() + "获取到了资源");
        } else {
          System.out.println(Thread.currentThread() + "被拒绝");
        }
      }).start();
    }

    //等待，往桶里放token
    Thread.sleep(3000);

    //继续瞬间10个线程进来拿token
    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        if (bucket.get()) {
          System.out.println(Thread.currentThread() + "获取到了资源");
        } else {
          System.out.println(Thread.currentThread() + "被拒绝");
        }
      }).start();
    }
  }


}
