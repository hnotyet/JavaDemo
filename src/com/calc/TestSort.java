package com.calc;
/**
 * 测试类
 * @author yest
 *
 */
public class TestSort {

	public static void printArr(int[] arr){
		for(int i: arr){
			System.out.print(i+"  ");
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 26, 53, 48, 15, 13, 46, 32, 15,42 };
		
		arr = PopSort.sort(arr);
		
		
		printArr(arr);
		
	}
}
