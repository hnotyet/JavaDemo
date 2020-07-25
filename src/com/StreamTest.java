package com;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/15
 */
public class StreamTest {

  public static void main(String[] args) {

    FileInputStream fis = null;
    BufferedInputStream bis = null;
    FileOutputStream fos = null;
    try {
      fis = new FileInputStream("/var/log/weekly.out");

      bis = new BufferedInputStream(fis);

      byte[] bytes = new byte[1024];

      fos = new FileOutputStream("/Users/yest/develop/IdeaProjects/demo/weekly.out");

      while (bis.read(bytes) > 0) {
        fos.write(bytes);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bis != null){
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fis != null){
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if(fos != null){
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }


  }
}
