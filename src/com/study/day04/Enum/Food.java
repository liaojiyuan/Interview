package com.study.day04.Enum;
/**
 *@author gcc
 *@date 2018年11月6日 下午9:18:14
 *@description 使用接口组织枚举 对一组数据分类，食物菜单分类而且希望这些菜单都属于food类型，如mainCourse主菜，fruit水果 drink 饮品
 *每种分类下有多种具体的菜式或食品，此时可以利用接口组织
*/
public interface Food {
	enum mainCourse implements Food{
		RICE,NOODLES,DUMPLING,CHINKEN,BEEF;
	}
	
	enum fruit implements Food{
		BANANA,APPLE,ORANGE,PEAR;
	}
	
	enum drink implements Food{
		TEA, MILK,COFFEE,GREEN_TEA,RED_TEA;
	}
}
