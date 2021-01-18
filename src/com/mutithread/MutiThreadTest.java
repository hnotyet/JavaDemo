package com.mutithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/14
 */
public class MutiThreadTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    String[] arr = {"123", "456", "789"};

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    List<FutureTask<String>> list = new ArrayList<>(4);

    for (int i = 0; i <= 2; i++) {
      FutureTask task = new FutureTask(new TakeIndex(i,arr ));
      list.add(task);
      executorService.submit(task);
    }

    for(FutureTask task :list){
      System.out.println(task.get());
    }

    executorService.shutdown();
  }


  static class TakeIndex implements Callable {

    private int index;
    private String[] arr;

    public TakeIndex(int index, String[] arr) {
      this.index = index;
      this.arr = arr;
    }

    @Override
    public String call() {
      if (this.arr.length == 0) {
        throw new RuntimeException("invalid parameter");
      }

      StringBuffer sb = new StringBuffer();
      for (String s : arr) {
        if (s.length() >= index) {
          sb.append(s.charAt(index));
        }
      }
      return sb.toString();
    }
  }

}
