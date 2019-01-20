package algorithm.leetCode.两个数组的交集;

/**
* @author gaochaochao
* @date 2019年1月20日 下午7:19:04
* @description
*/
public class TestBinarySearch {
	public static void main(String[] args) {
		int[] nums=new int[] {1,1,1,1,1};
		System.out.println(0==binarySearch(nums, 1));
		System.out.println(2==binarySearch(nums, 1));
		System.out.println(3==binarySearch(nums,1));
		System.out.println(4==binarySearch(nums,1));
	}
	private static int binarySearch(int[] nums,int key) {
		int lo=0,hi=nums.length-1;
		while(lo<=hi) {
		    int	mid=(lo+hi)>>1;
			if(nums[mid]<=key) {
				lo=mid+1;
			}else {
				hi=mid-1;
			}
		}
		if(key==nums[hi]) {
			return hi;
		}
		return -1;
	}

}
