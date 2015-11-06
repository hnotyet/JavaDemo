package com.calc;

/**
 * 选择排序
 * 找到数据中最小的元素，将它与第一个元素进行交换，再找次小元素，与第二个元素交换
 * @author yest
 *
 */
public class SelectionSort {

	
	public static int[]  sort(int[] arr){
		
		for(int i=0; i< arr.length-1;i++ ){
			int min = i;
			boolean flag = false;
			for(int j = i+1;j < arr.length;j++){
				if(arr[j]< arr[min]){
					min = j;
					flag = true;
				}
			}
			if(flag){
				int tmp = arr[min];
				arr[min] = arr[i];
				arr[i] = tmp;
			}
		}
		return arr;
	}
	
	
	
	
	
}
