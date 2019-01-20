package algorithm.leetCode.存在重复;

import java.util.HashSet;
import java.util.Set;

/**
* @author gaochaochao
* @date 2019年1月20日 下午4:16:35
* @description 使用Set集合去重
*/
public class Solution2 {
	public static boolean containsDuplicate(int[] nums) {
		int len=nums.length;
		if(len<2) {
			return false;
		}
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<len;i++) {
			if(set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
