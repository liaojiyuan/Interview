/**
 * 
 */
package algorithms.zcyCodeInterviewGuide.chapter9;

/**
 * @author Administrator
 * @date 2019年3月15日 上午9:15:20
 * @description 给定两个不等于0的整数M,N，求M和N的最大公约数 辗转相除法求最大公约数
 *              gcd(m,n)=gcd=(n,m%n)=...=gcd(result,0)=result;
 */
public class GCD {

	public static void main(String[] args) {
		System.out.println(gcd_nonrecrusive(17, 34));
		System.out.println(gcd_recrusive(134, 34));
	}

	public static int gcd_nonrecrusive(int m, int n) {
		int tmp = 0;
		do {
			tmp = m;
			m = n;
			n = tmp % n;
		} while (n != 0);
		return m;
	}

	public static int gcd_recrusive(int m, int n) {
		return (n == 0) ? m : gcd_recrusive(n, m % n);
	}
}
