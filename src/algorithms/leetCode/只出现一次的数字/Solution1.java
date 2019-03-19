package algorithms.leetCode.只出现一次的数字;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
/**
* @author gaochaochao
* @date 2019年1月20日 下午6:10:33
* @description 蛮力法，时间复杂度O(n2)
*/
public class Solution1 {
	public static int singleNumber(int[] nums) {
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        for(int i=0;i<len;i++){
            int data=nums[i];
            int j;
            for(j=0;j<len;j++){
                if(nums[j]==data && i!=j){
                    break;
                }
            }
            if(j==len){
                return data;
            }
        }
        return -1;
    }
}
