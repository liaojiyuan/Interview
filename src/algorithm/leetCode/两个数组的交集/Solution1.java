package algorithm.leetCode.两个数组的交集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
* @author gaochaochao
* @date 2019年1月20日 下午7:11:47
* @description //先排序，在统计，但是统计方法不恰当，导致超时，应该使用双指针法，详见Solution2
*/
public class Solution1 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		int len1=nums1.length;
        int len2=nums2.length;
        //有一个数组为空，则交集为空集  A∩∅=∅
        if(len1==0||len2==0) {
        	return new int[] {};
        }
		Arrays.sort(nums1);
        Arrays.sort(nums2);
        //nums1[a,b],nums2[c,d] ,a>d或者b<c，都没有交集，返回空数组
        if((nums1[0]>nums2[len2-1])||(nums1[len1-1]<nums2[0])) {
        	return new int[] {};
        }
        int[] small_nums=len1>len2?nums2:nums1;
        int[] large_nums=len1>len2?nums1:nums2;
        int len=small_nums.length;
        List<Integer> resultList=new ArrayList<>();
        int count=0;
        for(int i=0;i<len;i+=count){
            int data=small_nums[i];
            int index=binarySearch(large_nums, data);
            if(index<0) { //该元素不相交，继续比较下一个元素
            	continue;
            }else { //该元素在两个数组共有，求在交集中的重复次数
            	int c1=getDuplicate(small_nums,data,i+1,1);
            	int c2=getDuplicate(large_nums,data,index-1,-1);
            	count=c1;
            	int c=c1>c2?c2:c1;
            	for(int j=0;j<c;j++) {
            		resultList.add(data);
            	}
            }
        }
        int i=0;
        int [] result=new int[resultList.size()];
        for (Iterator<Integer> iterator = resultList.iterator(); iterator.hasNext();) {
			Integer data = (Integer) iterator.next();
			result[i++]=data;
		}
        return result;
    }
	private static int getDuplicate(int[] nums, int key,int index,int flag) {
		int count=1;
		while(true){
			if(index<nums.length && index>-1  && key==nums[index]) {
				count++;
				index+=flag;
			}else {
				return count;
			}
		}
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
	
	public static void main(String[] args) {
		int[] nums1=new int[] {4,9,5};
		int[] nums2=new int[] {9,4,9,8,4};
		int [] result=intersect(nums1,nums2);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
}
