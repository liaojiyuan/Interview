package algorithm.leetCode.旋转数组;
/**
 * 题目描述
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
/**
* @author gaochaochao
* @date 2019年1月20日 下午1:52:11
* @description 可以采取反转的方法，
* 先反转前n-k个元素，再反转后k个元素，然后再将整个数组反转，就能得到该数组旋转k个元素的结果了
* 示例 数组  1	2	3	4	5	6	7 ，k=3,n=7
* 先反转前n-k=4个元素，结果如下  4	3	2	1	5	6	7
* 再反转后k=3个元素，结果如下        4	3	2	1	7	6	5
* 最后反转整个数组,结果如下	    7	6	5	1	2	3	4
*/
public class Solution2 {
	public static  void rotate(int [] nums,int k) {
		int len=nums.length;
		if(len<2) {
			return ;
		}
		k%=len;
		if(k<=0) {
			return ;
		}
		reverse(nums,0,len-k);//nums[0,len-k)
		reverse(nums,len-k,len);//nums[len-k,len)
		reverse(nums,0,len);//nums[0,len)
	}
	/**
	 * 反转数组 nums[start,end) ,顾头不顾尾
	 * @param nums 数组
	 * @param start 起始位置
	 * @param end 结束位置
	 */
	private static void reverse(int[] nums, int start, int end) {
//		int mid=(start+end)>>1;//折半取中
		for(int i=start,j=end-1;i<j;i++,j--) {
			int tmp=nums[i];
			nums[i]=nums[j];
			nums[j]=tmp;
		}
	}
}
