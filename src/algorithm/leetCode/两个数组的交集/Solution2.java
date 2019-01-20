package algorithm.leetCode.两个数组的交集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
* @author gaochaochao
* @date 2019年1月20日 下午8:33:25
* @description 先排序 数组排序的算法时间复杂度最低是O(nlogn) 得到两个排好序的数组：A和B
* 在排好序好，要想得到数组的交集，只需要分别对A和B设置两个指针i,j（或者直接说是下标），进行循环(详情参考归并排序的合并示例代码)
* 时间复杂度为O(n)。综合排序的时间复杂度则整体复杂度为：O(nlogn)
*/
public class Solution2 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		int len1=nums1.length;
        int len2=nums2.length;
        //有一个数组为空，则交集为空集  A∩∅=∅
        if(len1==0||len2==0) {
        	return new int[0];
        }
		Arrays.sort(nums1);
        Arrays.sort(nums2);
        //nums1[a,b],nums2[c,d] ,a>d或者b<c，都没有交集，返回空数组
        if((nums1[0]>nums2[len2-1])||(nums1[len1-1]<nums2[0])) {
        	return new int[0];
        }
        int[] ret1=new int[len1>len2?len2:len1];
        List<Integer> resultList=new ArrayList<>();
        //双指针法 参考归并排序的合并示例代码
        int i=0,j=0,cnt=0;
        while(i<len1 && j<len2) {
        	if(nums1[i]<nums2[j]) {
        		i++;
        	}else if(nums1[i]==nums2[j]) {
        		ret1[cnt++]=nums1[i];
        		i++;j++;
        	}else {
        		j++;
        	}
        }
        return Arrays.copyOfRange(ret1, 0, cnt);
    }

}
