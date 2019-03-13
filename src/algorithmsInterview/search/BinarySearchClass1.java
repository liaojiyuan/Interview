/**
 * 
 */
package algorithmsInterview.search;

/**
 * @author Administrator
 * @date 2019年3月13日 下午1:28:02
 * @description 二分搜索
 */
public class BinarySearchClass1 {
	private static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static int binarySearch(int[] array, int key) {
		int lo = 1, hi = array.length;
		int mid = 0;
		while (lo <= hi) {
			mid = (lo + hi) >> 1;
			if (array[mid] < key)
				lo = mid + 1;
			else if (array[mid] == key)
				return mid;
			else
				hi = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("查找key=5是否在数组中");
	}
}
