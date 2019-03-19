/**
 * 
 */
package algorithms.zcyCodeInterviewGuide.chapter9;

import java.util.Scanner;

/**
 * @author Administrator
 * @date 2019年3月15日 上午11:30:19
 * @description 判断一个数是否是回文数 如果一个非负数左右完全对应，则该数是回文数 ，如 121,22等
 *              如果一个负数绝对值左右完全对应，则该数是回文数 ，如-121，-22等
 */
public class 判断一个数是否是回文数 {

	public static void main(String[] args) {
		method2();
	}

	// 判断是否是回文数
	/**
	 * 1假设判断的是非负数，先生成变量help，开始时help=1；
	 * 2用help不停乘以10，直到变得和num位数一样，如num=12321时，help=10000；
	 * 3则num/help就是最高位的数字，mun%10就是最低位数字，比较，如果不相等，立即返回false，
	 * 相等令num=(num/%help)/10,即num变成除去最高位和最低位的两个数字之后的值，同时help
	 * /=100,即让help与num保持位数相同； 4 如果num=0，表示所有数字都比较完成，返回true，否则重复第三步。
	 * 上述方法就是让num每次剥掉最高位和最低位两个数，然后逐渐完成所有对应的判断。如果n为负数，
	 * 先变成绝对值在判断，同时注意，32位整数最小值为-2的31次方，即-2147483648，它不能转成相应绝对值的； 明显不是回文数
	 */
	public static boolean isPalindrome(int n) {
		if (n == Integer.MIN_VALUE)
			return false;
		n = Math.abs(n);
		int help = 1;
		while (n / help >= 10) {// 防止help溢出
			help *= 10;
		}
		while (n != 0) {
			if (n / help != n % 10)
				return false;
			n = (n % help) / 10;
			help /= 100;
		}
		return true;
	}

	public static void method() {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[10];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			arr[i] = in.nextInt();
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
			sum += arr[i];
		}
		System.out.println("max=" + max + " min=" + min + " avg=" + sum * 1.0 / 10);
	}

	public static void method2() {
		Scanner bj = new Scanner(System.in);
		System.out.print("请输入圆的半径：");
		int r = bj.nextInt();// 半径
		double R = 2 * r;// 直径
		for (int i = 0; i <= R; i += 2) {
			double y;
			if (i <= r)
				y = r - i;
			else
				y = i - r;
			double x = Math.round(Math.sqrt(r * r - y * y)); // 循环输出
			for (int j = 0; j < r - x; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 0; j < 2 * x; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}

}
