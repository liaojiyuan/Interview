/**
 * 
 */
package algorithmsInterview.sort;

/**
 * @author Administrator
 * @date 2019年3月13日 下午12:07:27
 * @description 快速排序算法 时间复杂度O(nlogn),不稳定排序
 */
public class QuickSortClass {

	private static int[] array = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };

	public static void quickSort(int[] array, int lo, int hi) { // array[lo,hi]
		if (lo >= hi) {
			return;
		}
		int first = lo, last = hi;
		int pivot = array[lo];
		while (first < last) {
			while (first < last && array[last] >= pivot)
				--last;
			array[first] = array[last];
			while (first < last && array[first] <= pivot)
				++first;
			array[last] = array[first];
		}
		array[first] = pivot;
		quickSort(array, lo, first - 1);
		quickSort(array, first + 1, hi);
	}

	public static void main(String[] args) {
		quickSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
