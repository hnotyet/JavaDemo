package com.calc;

import java.util.Arrays;

public class MergeSort {
	
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int l = 0;
		int r = arr.length-1;
		
		sort(arr,l,r);
	}
	
	
	public static void sort(int[] arr,int l,int r) {

		if (l>=r){return;}


		int mid =  (l + r)/2;
	
		sort(arr,l,mid);
		sort(arr,mid+1,r);
		merge(arr,l,mid,r);	
	}

	
	public static void merge(int[] arr,int l ,int mid,int r) {
		int[] temp = new int[arr.length];
		
		int p1 = l;
		int p2 = mid+1 ;
		int p3 = r;
		
		int left =l ;
	
		while(p1 <= mid && p2 <= p3) {
			if(arr[p1] > arr[p2]) {
				temp[left++]= arr[p2++];
			}else {
				temp[left++] = arr[p1++];
			}
		}
		
		while(p1 <= mid) {
			temp[left++] = arr[p1++];
		}
		
		while(p2 <= p3) {
			temp[left++] = arr[p2++];
		}

		while(l <= r) {
			arr[l] =temp[l++];
		}
		
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = { 3, 5, 7, 90, 4, 2, 1, 3, 4, 5, 7, 8, 9 };
		mergeSort(arr);
		System.out.print(Arrays.toString(arr));
	}
}
