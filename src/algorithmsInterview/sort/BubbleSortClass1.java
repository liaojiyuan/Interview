/**
 * 
 */
package algorithmsInterview.sort;

/**
 * @author Administrator
 * @date 2019年3月13日 下午12:49:17
 * @description 冒泡排序算法1 ，不设置标志flag，外层循环每次都循环n-1次
 */
public class BubbleSortClass1 {
	private static int[] array = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };

	public static void bubbleSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					array[j] += array[j + 1];
					array[j + 1] = array[j] - array[j + 1];
					array[j] -= array[j + 1];
				}
			}
			for (int data : array) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		bubbleSort(array);
		// for (int i : array) {
		// System.out.print(i + " ");
		// }
		// System.out.println();
	}

}
