package com.trafficlimit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/16
 */
public class ReadWriteLockTest {

  public static void main(String[] args) {

    ReadWriteLock  lock = new ReentrantReadWriteLock();

    Lock readLock = lock.readLock() ;

    readLock.lock();

  }
}
