package algorithm.leetCode.两个数组的交集;

/**
* @author gaochaochao
* @date 2019年1月20日 下午7:19:04
* @description 二分查找方法  返回不大于key的最后一个元素
*/
public class BinarySearch {
	
	/**
	 * @param nums 数组
	 * @param key 关键词
	 * @return 当有多个元素命中时候，必须返回最靠后（index最大）;
	 * 失败时候，返回小于key的最大者（含哨兵nums[lo-1]）
	 * 返回值<0，表示未找到，返回值的绝对值所对应的那个元素是大于key的最小下标
	 */
	public static int binarySearch(int[] nums,int key) { //查找区间nums[0,length)
		if(0==nums.length){
			return -1;
		}
		int lo=0,hi=nums.length;
//		while(1<(hi-lo)) {  // 不能及时判断是否已经命中，直到有效查找区间宽度缩短为1时，算法终止才能判断出来
//		    int	mid=(lo+hi)>>1 ;//以中点为轴点，经过比较后确定深入
//			if(key < nums[mid]){ // key<nums[mid],则key若存在必属于左侧子区间nums[lo,mid)
//				hi=mid; 
//			}else{    //否则，若key>=nums[mid],则key存在必属于右侧子区间nums[mid,hi)
//				lo=mid;
//			}
//		} //出口时 hi=lo+1，查找区间仅含一个元素nums[lo]
//		//根据算法不变性,nums[0,lo)<=key<nums[hi,n),以及最后求得的空间nums[lo,hi)可以确定，
//		//如果key==nums[lo],则一定是重复元素中最大index下标，否则，一定是大于key的最小下标
//		return key==nums[lo]?lo:-hi;  //不能确保找不到时候如何准确插入位置index
		
		while(lo<hi){//不变性,nums[0,lo)<=key<nums[hi,n)
			int mid=(hi+lo)>>1;//以中点为轴点，经过比较后确定深入
			if(key < nums[mid]){ 
				hi=mid;  //nums[lo,mid)
			}else{    
				lo=mid+1; //nums(mid,hi)
			}
		}//出口时候，nums[lo==hi]为大于key的最小元素
		return --lo; //故lo-1即为不大于key的最大index
	} 
	//判断二叉查找结果是否找到，没找到插入值
//	int result=binarySearch(nums,key);
//	if(key==nums[result]){
//		System.out.println("查找成功");
//	}else{
//		insert(nums,result+1,key);//result+1是插入位置
//	}
	
	//特殊版本的二分查找
	public static int binarySearch_special(int [] nums,int key){ //维持不变性  nums[0,lo)<=key<nums[hi,length)
		int lo=0,hi=nums.length;
		int mid=0;
		while(lo<hi){
			mid=((lo+hi)>>1);
			if(key<nums[mid]){
				hi=mid; //key<nums[hi,length)
			}else{
				lo=mid+1; //nums[0,lo)<=e
			}
		}
		//最后得到一个宽度为0的区间----分界线 即大于key的最小者
		return --lo;
	}
	//普通版本的二分查找
	public static int binarySearch_common(int[] nums,int key){
		int lo=0,hi=nums.length;
		int mid=0;
		while(lo<hi){
			mid=(lo+hi)>>1;
			if(key<nums[mid]){
				hi=mid-1;
			}else if(key==nums[mid]){
				return mid;
			}else{
				lo=mid+1;
			}
		}
		return -1;
	}
}
