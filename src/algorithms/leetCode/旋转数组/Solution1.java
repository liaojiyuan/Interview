package algorithms.leetCode.旋转数组;
/**
 * 题目描述
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
/**
* @author gaochaochao
* @date 2019年1月20日 上午10:33:53
* @description  借助O(n)的空间解法，利用（i+k）%n=旋转后的位置可以将原数组的数据复制到新旋转数组中。
*/
public class Solution1 {
	public static void rotate(int[]nums,int k) {
		int len=nums.length;
		if(len<2) {// 数组长度为0或1 ，直接返回
			return ;
		}
		k%=len; //k取数组长度len的模
		if(k<=0 ) { //k是数组长度整数倍 或者k为负数
			return ;
		}
		int []copy_nums=new int[len];
		for(int i=0;i<nums.length;i++) {//（i+k）%n=旋转后的位置
			copy_nums[(i+k)%len]=nums[i];
		}
		for(int i=0;i<len;i++) {
			nums[i]=copy_nums[i];
		}
//		nums = Arrays.copyOf(copy_nums,len);
	}

}
