package com.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

  public static void main(String[] args) {
    Laptop laptop = new Laptop();
    TimeHander hander = new TimeHander(laptop);
    IComputer computer = (IComputer) Proxy
        .newProxyInstance(laptop.getClass().getClassLoader(), laptop.getClass().getInterfaces(),
            hander);
    computer.execute();
  }

}