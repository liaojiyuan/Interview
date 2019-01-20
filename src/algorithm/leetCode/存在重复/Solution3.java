package algorithm.leetCode.存在重复;
/**
* @author gaochaochao
* @date 2019年1月20日 下午5:02:25
* @description 边排序边比较重复,直到找到第一个重复元素之前的序列都是有序的了。
*/
public class Solution3 {
	 public static boolean containsDuplicate(int[] nums) {
        int len=nums.length;
		if(len<2) {
			return false;
		}
        for (int i = 1; i < nums.length;i++){
           int j=i-1;
           int temp=nums[i];
           while(j>=0 && nums[j]>temp){
               nums[j+1]=nums[j];
               j--;
           }
           nums[j+1]=temp;
           if(j>=0&&nums[j+1]==nums[j]){
               return true;
           }
        }
        return false;
	}
	 public static void main(String[] args) {
		 int[] nums=new int[] {2,5,1,7,3,6,0,2,4};
		 System.out.println(containsDuplicate(nums));
		 for(int i=0;i<nums.length;i++) {
	        System.out.print(nums[i]+" ");
	     }
	 }
}
