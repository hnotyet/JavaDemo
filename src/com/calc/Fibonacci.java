package com.calc;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {


  static int[] getFibArr1(int count) {
    int[] arr = new int[count];
    for(int i = 0 ;i < count; i++){
      arr[i]=getFib(i);
    }
    return arr;
  }

  static int[] getFibArr2(int count) {
    Map<Integer,Integer> map = new HashMap();
    int[] arr = new int[count];
    for(int i = 0 ;i < count; i++){
      arr[i]=getFib(i);


    }
    return arr;
  }


  static int getFib(int n) {
    if( n < 0){
      return 0;
    }else if(n==0){
      return 0;
    }else if(n==1 || n==2){
      return 1;
    }else {
      return getFib(n - 2) + getFib(n - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(getFibArr1(10));
  }






}
