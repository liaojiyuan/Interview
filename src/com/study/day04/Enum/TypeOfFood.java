
package com.study.day04.Enum;
import com.study.day04.Enum.Food;
import com.study.day04.Enum.Food.drink;
import com.study.day04.Enum.Food.fruit;
import com.study.day04.Enum.Food.mainCourse;

/**
 *@author gcc
 *@date 2018年11月6日 下午9:28:24
 *@description
*/
public class TypeOfFood {
	
	public static void main(String [] args) {
		Food food=mainCourse.BEEF;
		System.out.println(food);
		food=fruit.APPLE;
		food=drink.COFFEE;
	}

}
