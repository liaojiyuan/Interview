/**
 * 
 */
package algorithmsInterview.sort;

/**
 * @author Administrator
 * @date 2019年3月13日 下午12:49:17
 * @description 冒泡排序算法2（优化外层循环） ，设置标志flag，外层循环不一定每次都循环n-1次，
 *              如果有一次内层循环完成时，没有交换元素，表示此时已经有序。 时间复杂度：最好O(n)，最差O(n2)
 */
public class BubbleSortClass2 {
	private static int[] array = { 6, 1, 2, 10, 7, 3, 4, 5, 8, 9 };

	public static void bubbleSort(int[] array) {
		int length = array.length;
		boolean sorted = false;
		for (int i = 0; sorted = !sorted; i++) { // 优化外层循环
			for (int j = 0; j < length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					array[j] += array[j + 1];
					array[j + 1] = array[j] - array[j + 1];
					array[j] -= array[j + 1];
					sorted = false;
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
