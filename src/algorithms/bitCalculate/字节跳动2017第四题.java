/**
 * 
 */
package algorithms.bitCalculate;

import java.util.Scanner;

/**
 * @author Administrator
 * @date 2019年3月16日 上午8:09:34
 * @description 题目描述 给定 x, k ，求满足 x + y = x | y 的第 k 小的正整数 y 。 | 是二进制的或(or)运算，
 *              例如 3 | 5 = 7。比如当 x=5，k=1时返回 2，因为5+1=6 不等于 5|1=5，而 5+2=7 等于 5 | 2
 *              = 7。
 */
public class 字节跳动2017第四题 {

	public static void main(String[] args) {

	}

	/**
	 * 通过观察，可以知道x&y=0，即x的二进制位中，为1的位置，y中必须为0，那么与k的关系呢？k是符合条件的
	 * 第k小正整数，将k转换成二进制，插入到x中0的位置，即可得到结果 两个结论 1 x在二进制取1的位上，y不能做出改变，只能取0 2
	 * 把k表示成二进制数，填入x取0的比特位，x取1的比特位保持为0，得到y。
	 */
	public static int methodA() {
		Scanner in = new Scanner(System.in);
		int x, k, y = 0;
		x = in.nextInt();
		k = in.nextInt();
		int bitNum = 1;
		while (k != 0) {
			// (x & bitNum) == 0 说明x该位为0,可以把k的当前最后一位填入
			if ((x & bitNum) == 0) {
				// 用 (k&1) 取出最后一位，用 ans+=(bitNum*(k&1))把k的最后一位填入到当前bitNum指向的位置。
				y += (bitNum * (k & 1));
				// 填完后，k右移一位，去掉已经被填过的最后一位，bitNum也向左走一位，避免重复填入x的某个位置
				k >>= 1;
			}
			// 若x的某个位置为1，则跳过该位置，向左走一位并观察是否可以填入。
			bitNum <<= 1;
		}
		System.out.println(y);
		return y;
	}

}
