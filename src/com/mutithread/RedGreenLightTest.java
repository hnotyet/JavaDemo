package com.mutithread;

import com.mutithread.RedGreenLightTest.TrafficLight.Color;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/14
 */
public class RedGreenLightTest {

  static ReadWriteLock lock = new ReentrantReadWriteLock();

  public static void main(String[] args) {


  }


  static class Car implements Runnable {

    private TrafficLight light;

    public Car(TrafficLight light) {
      this.light = light;
    }

    @Override
    public void run() {

          while(true){
            synchronized (light){
            if(light.color.equals(Color.RED)){
              System.out.println(Thread.currentThread().getName()+",红灯等待中");
              try {
                light.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }else if(light.color.equals(Color.GREEN)){
              System.out.println(Thread.currentThread().getName()+",绿灯通行中");

            }
          }
        }
    }
  }


  static class TrafficLight {

    private Color color;


    static enum Color {
      RED,
      GREEN
    }
  }


}
