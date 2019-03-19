package algorithms.leetCode.只出现一次的数字;

import java.util.Arrays;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
/**
* @author gaochaochao
* @date 2019年1月20日 下午6:21:31
* @description 先排序，在查找比较 说明 ，根据题目条件，可以得出该数组长度为奇数，
* 排序后，符合条件元素只可能出现在奇数位置，所以查找过程中移动幅度为两个单元格，
* 也可以先判断排序后数组头，尾的元素值是否满足条件，然后在遍历查找
*/
public class Solution3 {
	public static int singleNumber(int[] nums) {
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i=0;i<len-1;i+=2) {
        	if(nums[i]!=nums[i+1]) {
        		return nums[i];
        	}
        }
        return nums[len-1];
    }
}
