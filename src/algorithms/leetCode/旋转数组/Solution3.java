package algorithms.leetCode.旋转数组;
/**
 * 题目描述
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
/**
* @author gaochaochao
* @date 2019年1月20日 下午2:22:51
* @description 依旧可以利用(i+k)%n等于新i的思路，不过这次是每次调换一个元素，后一个元素的调换基于上一个的位置
* 示例1  数组 1	2	3	5	7	n=5,k=2，数组长度为奇数
* 1
* 1	 2	3	5	7
* 		3             //第一趟
* 1	 2	1	5	7	
* 				7    //第二趟
* 1	 2	1	5	3
* 	 2               //第三趟
* 1	 7	1	5	3
* 			5        //第四趟
* 1	 7	1	2	3
* 1                  //第五趟
* 5	 7	1	2	3
* 示例2 数组 1	2	3	4	5	6	n=6,k=3,数组长度为偶数
* 	1                       //start=0
* 	1	2	3	4	5	6
* 				4
* 	1	2	3	1	5	6	//第一趟
* 	1	2                    //start==i,取i++，start++，cur=nums[i]
* 	4	2	3	1	5	6   //第二趟
* 					5
* 	4	2	3	1	2	6   //第三趟
* 		2	3               //start==i，取i++，start++，cur=nums[i]
* 	4	5	3	1	2	6   //第四趟
* 						6
* 	4	5	3	1	2	3   //第五趟
* 			3	1  			//start==i，取i++,start++,cur=nums[i]
* 	4	5	6	1	2	3 	//第六趟
*/
public class Solution3 {
	public static  void rotate(int [] nums,int k) {
		int len=nums.length;
		if(len==0 || (k%=len)<=0 || len==1) {
			return ;
		}
		int start=0;
		int count=1;
		int data=nums[0],cur=nums[0];
		int i=0;
		while(count<=len) {
			i=(i+k)%len;
			cur=nums[i];
			nums[i]=data;
			if(start==i) { //偶数长度数组可能会发生重复，导致每次只能交换特定位置的两个
				i++;
				start++;
				data=nums[i];
			}else {  //奇数长度数组不存在该问题
				data=cur;
			}
			
			count++;
		}
	}
}
