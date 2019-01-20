package com.study.day04.Enum;
/**
 *@author gcc
 *@date 2018年11月6日 下午9:45:11
 *@description 使用枚举创建单例
*/
public enum SingletonEnum {
	INSTANCE,
	;
	private String name; //该单例拥有的属性定义
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
}
