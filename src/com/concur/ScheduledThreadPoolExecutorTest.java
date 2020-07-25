package com.concur;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/16
 */
public class ScheduledThreadPoolExecutorTest {

  public static void main(String[] args) {

    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
//    executor.scheduleAtFixedRate(() -> {
//      bucket.put();
//    }, 0, 1, TimeUnit.SECONDS);

    executor.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {

      }
    },0, 1, TimeUnit.SECONDS);


  }
}
