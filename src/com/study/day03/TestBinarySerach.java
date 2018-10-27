package com.study.day03;

import java.util.Arrays;

public class TestBinarySerach {
	public static void main(String [] args) {
		int [] arr= {1,3,5,5,5,7,9};
		int result=Arrays.binarySearch(arr, 6);
		if(result<0)
			System.out.println(result);
		else
			System.out.println(result);
		
	}

}
