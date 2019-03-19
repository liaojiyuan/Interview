package algorithms.leetCode.存在重复;
/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
/**
* @author gaochaochao
* @date 2019年1月20日 下午3:47:08
* @description 蛮力法 时间复杂度 O(n2)
*/
public class Solution1 {
	public static boolean containsDuplicate(int[] nums) {
		int len=nums.length;
		if(len<2) {
			return false;
		}
		for(int i=0;i<len;i++) {
			int cur=nums[i];
			for(int j=0;j<len;j++) {
				if((cur==nums[j]) && (j!=i)) {
					return true;
				}
			}
		}
		return false;
	}

}
