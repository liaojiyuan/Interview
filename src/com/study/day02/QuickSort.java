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
		int first=s,last=e,pivot=arr[s];
		while(first<last) {
			while(first<last && arr[last]>=pivot) {
				--last;
			}
			arr[first]=arr[last];
			while(first<last && arr[first]<=pivot) {
				first++;
			}
			arr[last]=arr[first];
		}
		arr[first]=pivot;
		Arrays.stream(arr).forEach(System.out::print);
	/*	for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");*/
		System.out.println();
		quickSort(arr,s,first-1);
		quickSort(arr,first+1,e);
	}

}
