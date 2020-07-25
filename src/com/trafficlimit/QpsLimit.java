package com.trafficlimit;

/**
 * 固定时间窗口 限流
 *
 * @author yeshengtao
 */
public class QpsLimit {

  private static Long start_time = null;
  private volatile int count = 0;

  private int QPS_LIMIT = 100;

  static {
    start_time = System.currentTimeMillis();
  }

  public synchronized boolean isOverLimit() {
    Long now = System.currentTimeMillis();
    if (now - start_time >= 1000L) {
      if (++count > QPS_LIMIT) {
        return true;
      } else {
        start_time = now;
        count = 0;
      }
    } else {
      count++;
    }
    return false;
  }

}
