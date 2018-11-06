package com.study.day04.Enum;
/**
 *@author gcc
 *@date 2018年11月6日 下午8:41:12
 *@description  枚举用于switch语句
*/
enum  season{
	Spring,Summer,Autumn,Winter
}
public class SeasonEnum {
	public static void main(String [] args) {
		season current_season=season.Autumn;
		switch(current_season) {
		case Spring:System.out.println("当前季节是"+current_season+" 竹外桃花三两枝，春江水暖鸭先知");break;
		case Summer:System.out.println("当前季节是"+current_season+" 接天莲叶无穷碧，映日荷花别样红");break;
		case Autumn:System.out.println("当前季节是"+current_season+" 停车做外枫林晚，霜叶红于二月花");break;
		case Winter:System.out.println("当前季节是"+current_season+" 忽如一夜出风来，千树万树梨花开");break;
		}
	}
}
