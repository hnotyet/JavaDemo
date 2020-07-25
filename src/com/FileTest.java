package com;

import java.io.File;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/14
 */
public class FileTest {

  public static void main(String[] args) {

    File file = new File("/var/log/");
    if(file.isDirectory()){
      for(File file1 : file.listFiles()){
        System.out.println(file1.getAbsolutePath()+","+file1.isFile());
      }
    }
  }
}
