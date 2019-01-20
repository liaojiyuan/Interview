package com.study.day04.Enum;
/**
 *@author gcc
 *@date 2018年11月6日 下午9:47:36
 *@description
*/
public class TestSingletonEnum {
	public static void main(String []args) {
		SingletonEnum instance=SingletonEnum.INSTANCE;
		System.out.println(instance.getName());
		SingletonEnum instance2=SingletonEnum.INSTANCE;
		System.out.println(instance2.getName());
		System.out.println(instance==instance2);

	}
}
