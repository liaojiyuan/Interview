package com.study.day04.Enum;
import java.util.stream.Stream;
/**
 *@author gcc
 *@date 2018年11月6日 下午8:13:25
 *@description 使用枚举类型规范
 * 1 枚举类名建议带后缀Enum，枚举成员名称全大写，单词之间用下划线分隔
 * 2 枚举其实是特殊的常量类，且构造方法被默认强制是私有
*/
public enum CarInfoEnum {
	dongfeng("东风",15.8),
	benchi("奔驰",25.0),
	yiqi("一汽",18.5),
	baoma("宝马",35.7),
	xuelai("雪莱",100.5),
	;
	
	/**
	 * enum的构造方法要么是private ，要么是默认（默认私有），prtected和public都不行
	 * @param name
	 * @param price
	 */
	CarInfoEnum(String name,Double price) {
		this.name=name;
		this.price= price;
	}
	
	private String name;
	private Double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "名称："+this.getName()+" 价格："+this.getPrice();
	}
	
	public static void main(String [] args) {
		//获取枚举对象
		CarInfoEnum carEnum =CarInfoEnum.valueOf("dongfeng");
		System.out.println(carEnum.toString());
		
		//枚举遍历 方法1 使用java8新特性 方法引用、lambda表达式、Stream流
		CarInfoEnum[]  cars= CarInfoEnum.values();
		Stream.of(cars).forEach(System.out::println);
		
		//枚举遍历 方法2 增强for
		for(CarInfoEnum car :CarInfoEnum.values()) {
			System.out.println(car);
		}
	}

}
