package com.xuetangx.data_structure_and_algorithms.ready;
/**
* @author gaochaochao
* @date 2019年1月29日 下午10:56:13
* @description 冒泡排序
*/
public class BubbleSort {
	
	public static void bubbleSort_1(int []nums) {
		//数组长度
		int n=nums.length;
		//sorted 标志数组是否有序，假设刚开始sorted为无序，注意每一轮内层循环结束，必然有一个元素已经处在其对应的有序位置
		//即不变性：经k趟扫描以后，最大的k个元素必然已经就位。所以要n--
		//且单调性：经k趟扫描之后，问题规模缩减为n-k
		//且正确性：经过至多n趟扫描，算法必然终止，且能给出正确答案。
		for(boolean sorted=false;sorted=!sorted;n--) {//反复扫描交换，每一趟
			//内层比较
			for(int j=1;j<n;j++) {//自左向右，逐对检查nums[0,n)内各相邻元素的有序性
				if(nums[j-1]>nums[j]) {//如果逆序，则交换
					nums[j-1]^=nums[j];
					nums[j]^=nums[j-1];
					nums[j-1]^=nums[j]; //交换 A=A^B,B=A^B=A^B^B=A,A=A^B=A^B^A=B;
//					int tmp=nums[j-1];
//					nums[j-1]=nums[j];
//					nums[j]=tmp; 交换
					sorted=false; //并且清除全局有序标志
				}//if
			}//for
		}//for
	}//function
	
	public static void bubbleSort_2(int []nums) {
		int n=nums.length;
		for(int i=0;i<n-1;i++) { //外层循环最多扫描n-1趟
			boolean sorted=true;
			for(int j=1;j<n-i;j++) { //内层循环在nums[0,n-i)区间逐对检查相邻元素的有序性
				if(nums[j-1]>nums[j]) {//若无序，交换
					int tmp=nums[j-1];
					nums[j-1]=nums[j];
					nums[j]=tmp;
					sorted=false; //并且置全局有序标志为false
				}
			}
			if(sorted) { //每一趟内层循环结束，校验一下是否本次循环有逆序对，如果没有，则已经有序，跳出循环。
				break;
			}
		}
	}
	
	public static void  bubbleSort_3(int [] nums) {
		int n=nums.length;
		while( 0 != ( n = bubble(nums,n) ) );
	}

	private static int bubble(int[] nums, int n) {
		int last=0;
		for(int i=1;i<n;i++) {
			if(nums[i-1]>nums[i]) {
				last=i;
				int tmp=nums[i-1];
				nums[i-1]=nums[i];
				nums[i]=tmp;
			}
		}
		return last;
	}
	
}
