/**
 * 
 */
package algorithms.zcyCodeInterviewGuide.chapter9;

/**
 * @author Administrator
 * @date 2019年3月15日 上午8:23:56
 * @description 随机函数
 */
public class RandFunction {

	public static void main(String[] args) {
		// testRand01();

		testRand1To7();

	}

	// rand01p方法以p概率产生0，以1-p概率产生1
	public static int rand01p() {
		double p = 0.60;
		return Math.random() < p ? 0 : 1;
	}

	// 虽然rand01p产生0,1概率不相等，但是 产生01和10的概率都是p(1-p)
	// 等概率产生0和1
	public static int rand01() {
		int result;
		do {
			result = rand01p();
		} while (result == rand01p());// 产生两次结果，如果两次结果相同则继续，直到结果不同结果
		return result;
	}

	public static void testRand01() {
		long res0 = 0L, res1 = 0L;
		for (long i = 0; i < 100000000L; ++i) {
			long res = (0 == rand01()) ? ++res0 : ++res1;
		}
		System.out.println(res0 + " " + res1 + " " + res0 * 1.0 / res1);
	}

	public static int rand1To5() {
		return (int) (Math.random() * 5) + 1;
	}

	/**
	 * @description 步骤1 rand1To5()等概率随机产生1,2,3,4,5 步骤2
	 *              rand1To5()-1等概率随机产生0,1,2,3,4 步骤3
	 *              (rand1To5-1)*4等概率随机产生0,5,10,15,20 步骤4
	 *              (rand1To5()-1)*4+(rand1To5()-1)等概率产生0,1,2,3,4,...,24.
	 *              注意，这两个rand1To5()是指独立的两次调用，不能化简，这是“插空儿”过程 步骤5
	 *              如果步骤4产生的数大于20，则重复步骤4，直到产生的数在区间【0,20】,同时可以轻易
	 *              知道，出现【21,24】的概率会均等分配到【0,20】上，这是“筛”过程 步骤6
	 *              步骤5等概率产生【0,20】，所以步骤5结果进行%7操作，就会等概率产生【0,6】再+1。
	 * @param
	 * @return int
	 */
	public static int rand1To7() {
		int result = 0;
		do {
			result = (rand1To5() - 1) * 4 + (rand1To5() - 1);
		} while (result > 20);
		return result % 7 + 1;
	}

	public static void testRand1To7() {
		long[] arr = new long[8];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		for (long i = 0; i < 700000000L; ++i) {
			++arr[rand1To7()];
		}
		for (Long data : arr) {
			System.out.print(data + " ");
		}
	}
}
