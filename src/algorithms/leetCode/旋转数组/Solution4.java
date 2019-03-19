package algorithms.leetCode.旋转数组;
/**
 * 题目描述
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
/**
* @author gaochaochao
* @date 2019年1月20日 下午2:55:53
* @description 实现思路，取数组长度的一半记为half_len,
	 * 如果给定k值<=half_len,则
		 * （1）将nums[len-k,len-1]这一区间值拷贝到copy_nums中
		 * （2）将nums[0,len-k-1]这一区间值向右移k个单元格长度，（注意是从后往前方向，
		 * 	即先nums[len-k-1],接着nums[len-k-2],...nums[0]，这样不会出现覆盖现象）
		 * （3）最后将copy_nums值还原到nums[0,k-1]位置。
		 * 示例1 数组 	1	2	3	4	5	6  n=6,k=3,half_len=3,k<=half_len
		 * 			拷贝nums[3,5]给copy_nums 即 copy_nums 	4	5	6
		 * 			nums[0,2]右移3个单元格长度 即nums 	1	2	3	1	2	3
		 * 			还原nums[0,2]值 	4	5	6	1	2	3
	 *如果给定k值>half_len(不可能超过len，因为已经取模运算的k值了)则
		 *记remain=len-k；
		 *（1）将nums[0,remain-1]这一区间值拷贝到copy_nums中
		 *（2）将nums[remain,len-1]这一区间值向左移remain个单元格长度，（注意是从前向后方向，
		 *即先nums[remain],接着nums[remain+1],...nums[len-1],这样不会出现覆盖现象)
		 *(3)最后将copy_nums值还原到nums[k,len-1]位置
		 *	示例2数组	1	2	3	4	5	n=5，k=3，half_len=2,k>half_len,remian=2
		 *拷贝nums[0,1]给copy_nums 即copy_nums  1	2
		 *nums[2,4]左移2个单元格即 	3	4	5	4	5
		 *还原nums[3,4]  3	4	5	1	2
*/
public class Solution4 {
	public static  void rotate(int [] nums,int k) {
		int len=nums.length;
		if(len==0 || (k%=len)<=0 || len==1) {
			return ;
		}
		int half_len=len>>1; // 取半
        if(k<=half_len){ // k小于等于数组长度一半
			int[] copy_nums=new int[k];
			for(int i=0;i<k;i++){ //将数组尾部k个元素复制到copy_nums保留
				copy_nums[i]=nums[len-k+i];
			}
			for(int i=len-k-1,j=len-1;i>=0;i--,j--){ //将数组头部len-k个元素右移k个单元长度（注意从后向前移动，否则可能会覆盖）
				nums[j]=nums[i];
			}
			for(int i=0;i<k;i++){ //将尾部k个元素移到头部k个位置
				nums[i]=copy_nums[i];
			}
		}else{ //k大于数组长度一半
			int remain=len-k;
			int[] copy_nums=new int[remain];
			for(int i=0;i<remain;i++){//将前len-k个元素拷贝到copy_nums保留
				copy_nums[i]=nums[i];
			}
			for(int i=0,j=len-k;i<k;i++,j++){ //将尾部k个元素左移len-k个单元格长度（注意从前向后移动，否则可能会覆盖）
				nums[i]=nums[j];
			}
			for(int i=0;i<remain;i++){//将头部len-k个元素移到尾部k个位置
				nums[k+i]=copy_nums[i];
			}
		}
	}

}
