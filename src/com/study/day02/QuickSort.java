package com.study.day02;

import java.util.Arrays;

/**
 *@author gcc
 *@date 2018年10月25日 上午11:09:51
 *@description  快速排序
*/
public class QuickSort {
	
	public static void main(String []args) {
		int [] arr= {49,38,65,97,76,13,27,50};
		quickSort(arr,0,arr.length-1);
	}
	public static void quickSort(int [] arr,int s,int e) { //arr[s,e]
		if(s>=e) {
			return ;
		}
		int first=s,last=e,povit=arr[s];
		while(first<last) {
			while(first<last && arr[last]>=povit) {
				--last;
			}
			arr[first]=arr[last];
			while(first<last && arr[first]<=povit) {
				first++;
			}
			arr[last]=arr[first];
		}
		arr[first]=povit;
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		/*Arrays.asList(arr).forEach(i->{
			System.out.print(i+" ");
			System.out.println();
		});*/
		quickSort(arr,s,first-1);
		quickSort(arr,first+1,e);
	}

}
