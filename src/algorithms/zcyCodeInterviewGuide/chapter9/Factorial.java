/**
 * 
 */
package algorithms.zcyCodeInterviewGuide.chapter9;

/**
 * @author Administrator
 * @date 2019年3月15日 上午9:41:21
 * @description 阶乘相关问题 两方面：其一 高精度计算 其二 数论相关
 */
public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial_binaryNonZeroPosition2(12));
	}

	// 求一个阶乘的最后三位数字是多少
	// 并不需要知道阶乘结果，每次都把中间结果对1000取模即可
	public static int factorial_lastThreeNums(int n) {
		int res = 1;
		for (int i = 2; i <= n; ++i) {
			res *= i;
			res %= 1000;// 对1000取模，只需要知道结果的最后三位数字，取模不影响后续阶乘运算
		}
		return res;
	}

	// 求一个阶乘结果，从右往左开始，第一个非0的数字是多少
	public static int factorial_nonZeroNumFormRight(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
			while (true) {
				if (res % 10 == 0) {
					res /= 10; // 每次计算出来的数，将后面的0都去掉
				} else {
					res %= 1000; // 取余数的时候应该取大一点，防止进位出错
					break;
				}
			}
		}
		while (true) {
			if (res % 10 == 0) {
				res /= 10; // 还是将最后结果的0都去掉
			} else {
				break; // 取个余数即可
			}
		}
		System.out.println(res % 10);
		return res % 10;
	}

	// 统计阶乘末尾0的个数 最优解时间复杂度O(logN)，以5为底数
	public static int factorail_zeroCounts(int n) {
		if (n < 0) {
			return 0;
		}
		int res = 0;
		do {
			res += n / 5;
			n /= 5;
		} while (n != 0);
		return res;
	}

	/**
	 * question 给定一个非负整数N，如果用二进制数表示N！结果，返回最低位的1在哪个位置上，认为最右边的位置为0 如
	 * 1！=1，最低位1在0位置上，2！=2，最低位1在1位置上，1000000000！最低位的1在999999987位置上
	 * 
	 * solution: 最低位置的1在哪个位置上，完全取决于1~N的数中因子2有多少个，只要出现一次2，最低位的1就会
	 * 向左移一位。所以，如果把N!结果中因子2的总个数记为Z，则Z=N/2+N/4+N/8+。。。
	 */
	public static int factorial_binaryNonZeroPosition1(int n) {
		if (n < -1) {
			return -1;
		}
		int res = 0;
		do {
			n >>>= 1;// n无符号右移1位，即相当于缩小1/2
			res += n;
		} while (n != 0);
		return res;
	}

	/**
	 * 解法二 一个推导公式，Z为N!结果中因子2的总个数，m为N的二进制表达式中1的个数 则 Z=N-m；
	 */
	public static int factorial_binaryNonZeroPosition2(int n) {
		if (n < -1) {
			return -1;
		}
		int m = 0;
		int tmp = n;
		while (tmp != 0) {
			m += (tmp & 1);
			tmp >>>= 1;// 右移一位，缩小一半
		}
		return n - m;
	}
}
