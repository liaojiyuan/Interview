package algorithm.leetCode.只出现一次的数字;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
/**
* @author gaochaochao
* @date 2019年1月20日 下午6:12:14
* @description Set去重操作
*/
public class Solution2 {
	public static int singleNumber(int[] nums) {
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<len;i++) {
        	if(!set.contains(nums[i])) {
        		set.add(nums[i]);
        	}else {
        		set.remove(nums[i]);
        	}
        }
        Iterator<Integer> iterator = set.iterator();
       if(iterator.hasNext()) {
			return Integer.parseInt(iterator.next().toString());
			
		}
        return -1;
    }

}
