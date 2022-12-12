package com.calc;

/**
 * 快速排序
 * @author yest
 *
 */
public class QuickSort {


	/**
	 * 从右向左找第一个小于X的数，换到左边
	 * 从左找向右找第一个大于X的数，换到右边
	 * @param a
	 * @param l
	 * @param r
	 */
	public static void quickSort(int[] a, int l, int r) {

		if (l < r) {
			int i,j,x;

			i = l;
			j = r;
			x = a[i];
			while (i < j) {
				while(i < j && a[j] > x)
					j--; // 从右向左找第一个小于x的数
				if(i < j)
					a[i++] = a[j];
				while(i < j && a[i] < x)
					i++; // 从左向右找第一个大于x的数
				if(i < j)
					a[j--] = a[i];
			}
			a[i] = x;
			quickSort(a, l, i-1); /* 递归调用 */
			quickSort(a, i+1, r); /* 递归调用 */
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] i = { 26, 53, 48, 15, 13, 46, 32, 15,42 };
		quickSort(i, 0, i.length - 1);
		for (int ii : i) {
			System.out.print(ii + " ");
		}
	}

	
}