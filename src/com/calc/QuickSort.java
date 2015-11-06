package com.calc;

/**
 * 快速排序
 * @author yest
 *
 */
public class QuickSort {

	/**
	 * 快速排序，对整数型数组o进行
	 * 
	 * @param o
	 * @param low
	 * @param hight
	 */
	public static void quiteSort(int[] o, int low, int hight) {
		if (low < hight) {
			int povitePosition = adjust(o, low, hight);
			quiteSort(o, low, povitePosition - 1);
			quiteSort(o, povitePosition + 1, hight);
		}
	}

	/**
	 * 进行调整
	 * 
	 * @param o
	 * @param low
	 * @param hight
	 * @return
	 */
	private static int adjust(int[] o, int low, int hight) {// 选定枢轴为low所对应的值
		int pivote = o[low];
		System.out.println("初始-------");
		while (low < hight) {
			while (low < hight  && pivote  <= o[hight]) {// 高位找到比povite大，则符合要求，继续寻找
				hight--;
			}
			o[low] = o[hight];
			while (low < hight && pivote >= o[low]) { // 低位开始找到比povite小，符合要求，继续寻找
				low++;
			}
			o[hight] = o[low];
			
		}
		o[low] = pivote;
		System.out.println("一轮结束");
		return low;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] i = { 26, 53, 48, 15, 13, 46, 32, 15,42 };
		quiteSort(i, 0, i.length - 1);
		for (int ii : i) {
			System.out.print(ii + " ");
		}
	}

	
}