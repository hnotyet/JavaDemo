package com.calc;

public class PopSort {


	public  static void printArr(int[] o){
		for(int i :o){
			System.out.print(i+"  ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 26, 53, 48, 15, 13, 46, 32, 15,42 };
		for(int i=0;i<arr.length-1;i++ ){
			for(int j=0;j< arr.length-1-i;j++){
				if(arr[j]>=arr[j+1]){
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		printArr(arr);
	}
}
