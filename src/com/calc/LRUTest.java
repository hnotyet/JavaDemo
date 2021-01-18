package com.calc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2021/1/16
 */
public class LRUTest {


  public class LRUCache extends LinkedHashMap<Integer, Integer>{

    //private LinkedHashMap<K, V> map = new LinkedHashMap<K, V>(100);

    //private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    private int capacity;

    public LRUCache(int capacity) {
      super(capacity, 0.75F, true);
      this.capacity = capacity;
    }

    public Integer get(Integer key) {
//      try{
//        lock.readLock().lock();
        return super.getOrDefault(key, -1);
//      }finally {
//        lock.readLock().unlock();
//      }
    }

    public void put(int key, int value) {
//      try{
//        lock.writeLock().lock();
        super.put(key, value);
//      }finally {
//        lock.writeLock().unlock();
//      }

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
      return size() > capacity;
    }
  }


}
