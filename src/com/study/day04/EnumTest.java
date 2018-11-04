package com.study.day04;
//枚举类型只能在顶级类，接口，静态上下文中定义，不能定义在方法里面。
enum color{red,green,yellow};

public class EnumTest {
	
	enum day{monday,tueday,wednesday,thursday,friday,saturday,sunday};
	
	static enum course{chinese,english,math,science};
	
	public static void main(String [] args) {
		System.out.println(day.values());
		System.out.println(color.valueOf("red"));
		System.out.println(course.chinese);
	}
}
