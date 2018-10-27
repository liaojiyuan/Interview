package com.study.day02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *@author gcc
 *@date 2018年10月25日 下午3:33:19
 *@description春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，
 *他是这样定义的： “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
 *
 *输入数据有多组，每组占一行，包括两个整数m和n（100<=m<=n<=999）。
 *
 *对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，
 *输出的水仙花数必须大于等于m,并且小于等于n，如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开; 
 *如果给定的范围内不存在水仙花数，则输出no; 每个测试实例的输出占一行。
*/
public class TestScannerFromConsole {
	
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		ArrayList<int[]> list=new ArrayList<>();
		while(scanner.hasNext()) {
			int [] arrays=new int[2];
			arrays[0]=scanner.nextInt();
			arrays[1]=scanner.nextInt();
			list.add(arrays);
		}
		list.forEach(arrays->{
			shuixianhua(arrays);
		});
		scanner.close();
	}

	private static void shuixianhua(int[] arrays) {
		int flag=0;
		for(int a=arrays[0];a<=arrays[1];a++) {
			flag+=shuixian(a);
		}
		if(flag>0) {
			System.out.println();
		}else {
			System.out.println("no");
		}
		
		
	}

	private static int shuixian(int a) {
//		int i=a%100; 不能得到百位上的数字
		int i=a/100%10;//百位
		int j=a/10%10; //十位
		int k=a%10; //个位数字
		if(a == ((int)Math.pow(i, 3)+(int)Math.pow(j, 3)+(int)Math.pow(k, 3))) {
			System.out.print(a+" ");
			return 1;
		}
		return 0;
	}

}
