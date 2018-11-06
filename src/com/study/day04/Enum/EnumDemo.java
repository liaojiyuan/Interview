package com.study.day04.Enum;
/**
 *@author gcc
 *@date 2018年11月6日 下午9:13:42
 *@description enum 实现多接口
*/
interface foodInterface {
	void eat();
}

interface sport{
	void run();
}
public enum EnumDemo implements foodInterface,sport{
	FOOD,
	SPORT,
	; //分号分隔枚举实例值与自定义方法

	@Override
	public void run() {
		System.out.println("run ......");		
	}

	@Override
	public void eat() {
		System.out.println("eat ......");		
	}

}
