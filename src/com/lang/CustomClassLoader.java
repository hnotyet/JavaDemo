package com.lang;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/9
 */
public class CustomClassLoader extends ClassLoader {


  @Override
  protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
    return super.loadClass(name, resolve);
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    return super.findClass(name);
  }
}
