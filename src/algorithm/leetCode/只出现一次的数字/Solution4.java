package algorithm.leetCode.只出现一次的数字;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
/**
* @author gaochaochao
* @date 2019年1月20日 下午6:33:52
* @description  使用异或运算，根绝条件，可以得出知道仅有一个元素出现一次，其他元素都初夏两次，
* 而且根据给出的函数，只需要返回值而不需要知道位置，因此，使用异或运算，将数组所有元素异或操作，最后得出的结果就是该出现一次的元素值。
*/
public class Solution4 {
	public static int singleNumber(int[] nums) {
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        int result=0;
        for(int data:nums) {
        	result^=data;
        }
        return result;
    }
}
