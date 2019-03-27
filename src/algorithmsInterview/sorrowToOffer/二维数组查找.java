/**
 * 
 */
package algorithmsInterview.sorrowToOffer;

/**
 * @author Administrator
 * @date 2019年3月19日 下午7:42:06
 * @description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序 ，每一列都按照从上到下递增的顺序排序。
 *              请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class 二维数组查找 {
	static int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };

	/*
	 * 利用二维数组由上到下，由左到右递增的规律，那么选取右上角或者左下角的元素a[row][col]与target进行比较，
	 * 选取右上角array[0][col-1] 如果
	 * target>元素array[row][col]，那么target必定在元素array[row][col]下面，此时row++；
	 * 如果target==元素array[row][col]找到返回true
	 * 如果target<元素array[row][col],那么target必定在元素array[row][col]左边，此时col--；
	 * 
	 * 选取左下角元素array[row-1][0]
	 * 如果target<元素array[row][col],那么target必定在元素array[row][col]上面，此时row--；
	 * 如果target==元素array[row][col]找到返回true
	 * 如果target>元素array[row][col]，那么target必定在元素array[row][col]右边，此时col++
	 */
	public boolean find(int target, int[][] array) {
		if (null == array || 0 == array.length || 0 == array[0].length) {
			return false;
		}
		int row = array.length;
		int col = array[0].length;
		if (target < array[0][0] || target > array[row - 1][col - 1]) {
			return false;
		}
		int i = 0, j = col - 1;
		while (i < row && j >= 0) {
			if (target < array[i][j]) {
				j--;
			} else if (target == array[i][j]) {
				return true;
			} else {
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		二维数组查找 main = new 二维数组查找();
		System.out.println(main.find(7, array));
	}
}
