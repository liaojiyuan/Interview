/**
 * 
 */
package algorithms.bitCalculate;

import java.util.Scanner;

/**
 * @author Administrator
 * @date 2019年3月16日 上午10:04:44
 * @description 1,4,16,64元硬币 1024元纸币面值，购买商品花N元，最少找零多少个硬币
 */

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {// 注意while处理多个case
			int n = in.nextInt();
			int m = 1024 - n;
			int count = 0;
			if (m != 0) {
				count += (m / 64 + m % 64 / 16 + m % 64 % 16 / 4 + m % 64 % 16 % 4);
			}
			System.out.println(count);
		}
	}
}