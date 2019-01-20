package algorithm.leetCode.两个数组的交集;

import java.util.Arrays;

/**
* @author gaochaochao
* @date 2019年1月20日 下午8:52:00
* @description 1ms的快速执行方法
*/
public class Solution3 {
	public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)   {
            return new int[0];
        }
        int[] ret1 = new int[Math.max(nums1.length, nums2.length)];
        int len1 = 0;
        boolean[] bl1 = new boolean[ret1.length];
        for (int i=0; i < nums2.length; i++) {
            int start = 0;
            while( (start = find(nums1, nums2[i], start)) != -1 ) {
                if(bl1[start] == false) {
                    ret1[len1++] = nums2[i];
                    bl1[start] = true;
                    break;
                }
                start++;
            }
        }
        return Arrays.copyOfRange(ret1, 0, len1);
    }

    private static int find(int[] nums, int val, int start) {
        for (; start < nums.length; start ++) {
            if (nums[start] == val) {
                return start;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
		int[] nums1=new int[] {4,9,5,4};
		int[] nums2=new int[] {9,4,9,8,4};
		int [] result=intersect(nums2,nums1);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}

}
