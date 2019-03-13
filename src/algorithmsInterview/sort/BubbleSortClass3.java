/**
 * 
 */
package algorithmsInterview.sort;

/**
 * @author Administrator
 * @date 2019年3月13日 下午12:49:17
 * @description 冒泡排序算法3（优化内层循环） ，在每趟扫描中，记住最后一次交换发生的位置lastExchange，
 *              （该位置之后的相邻记录均已有序）。下一趟排序开始时，R[1..lastExchange-1]是无序区，
 *              R[lastExchange..n]是有序区。这样，一趟排序可能使当前无序区扩充多个记录，
 *              因此记住最后一次交换发生的位置lastExchange，从而减少排序的趟数
 */
public class BubbleSortClass3 {
	private static int[] array = { 6, 1, 2, 10, 7, 3, 4, 5, 8, 9 };

	public static void bubbleSort(int[] array) {
		int k = array.length - 1, lastExchange = 0;
		boolean sorted = false;
		while (sorted = !sorted) {
			for (int j = 0; j < k; j++) {
				if (array[j] > array[j + 1]) {
					array[j] += array[j + 1];
					array[j + 1] = array[j] - array[j + 1];
					array[j] -= array[j + 1];
					sorted = false;
					lastExchange = j; // 记录交换位置
				}
			}
			k = lastExchange;// 获取内层循环最后一次交换的位置
			for (int data : array) {
				System.out.print(data + " ");
			}
			System.out.print(array[k] + "\n");
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
