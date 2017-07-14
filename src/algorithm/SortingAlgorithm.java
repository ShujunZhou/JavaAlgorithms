package algorithm;

import utils.MyOut;

/**
 * 排序算法类库
 */
public class SortingAlgorithm {

	/**
	 * 升序的冒泡排序
	 */
	public static int[] bubbleSort(int[] arrayint){
		for (int i = 0; i < arrayint.length; i++) {
			for (int j = i + 1; j < arrayint.length; j++) {
				int sample = 0;
				if (arrayint[j] < arrayint[i]) {
					sample = arrayint[j];
					arrayint[j] = arrayint[i];
					arrayint[i] = sample;
				}
			}
		}
		return arrayint;
	}

	/**
	 * 升序的插入排序，
	 */
	public static int[] insertionSort(int[] arrayInt) {
		for (int j = 1; j < arrayInt.length; j++) {
			int key = arrayInt[j];
			int i = j - 1;
			while (i >= 0 && arrayInt[i] > key) {
				arrayInt[i + 1] = arrayInt[i];
				i--;
			}
			arrayInt[i + 1] = key;
		}

		return arrayInt;
	}

	/**
	 * 升序的桶排序
	 */
	public static void tunSort(){
		int[] a = new int[]{102,123,123,143,187,199,167,155,123};
		int min = a[0], max = a[0];
		for(int i = 0;i<a.length;i++){
			if(a[i]>max) max = a[i];
			if(a[i]<min) min = a[i];
		}

		int length = max - min + 1;
		int[] sort = new int[length];
		for(int i = 0;i<a.length;i++){
			sort[a[i] - min]++;
		}
		for(int i = 0;i<sort.length;i++){
			if(sort[i] == 0) continue;
			else {
				for(int j = 0;j<sort[i];j++){
					System.out.print(" "+ (i+min) +" ");
				}
			}
		}
	}

	/**
	 * 升序的归并排序
	 * @param arrayInt
	 * @return
	 */
	public static int[] mergeSort(int[] arrayInt, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arrayInt, low, mid);
			mergeSort(arrayInt, mid + 1, high);
			merge(arrayInt, low, mid, high);
		}
		return arrayInt;
	}


	/**
	 * 归并排序的一部分，将两个排列好的数组合并成一个数组
	 * @param arrayInt
	 * @param low
	 * @param mid
	 * @param high
	 * @return
	 */
	private static void merge(int[] arrayInt, int low, int mid, int high) {

		int a = mid - low + 1;
		int b = high - mid;
		int[] xx = new int[a + 1];
		int[] yy = new int[b + 1];

		for (int i = 0; i < xx.length - 1; i++) {
			xx[i] = arrayInt[low + i];
		}

		for (int i = 0; i < yy.length - 1; i++) {
			yy[i] = arrayInt[mid + 1 + i];
		}
		/**
		 * 设置哨兵
		 */
		xx[a] = Integer.MAX_VALUE;
		yy[b] = Integer.MAX_VALUE;

		int n = 0;
		int m = 0;

		for (int i = low; i <= high; i++) {
			if (xx[n] < yy[m]) {
				arrayInt[i] = xx[n];
				n = n + 1;
			} else {
				arrayInt[i] = yy[m];
				m = m + 1;
			}
		}
	}


}
