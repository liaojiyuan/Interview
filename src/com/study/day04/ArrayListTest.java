package com.study.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
* @author gaochaochao
* @date 2018年11月4日 下午10:05:34
* @description 测试集合的遍历
*/
public class ArrayListTest {
	enum day{monday,tueday,wednesday,thursday,friday,saturday,sunday};
	public static void main(String [] args) {
		List<String> list=new ArrayList<>();
		list.add("monday");
		list.add("tuesdat");
		list.add("wednesday");
		list.add("thursday");
		list.add("friday");
		list.add("saturday");
		list.add("sunday");
		//集合遍历方法1 增强for
		for(String s:list) {
			System.out.print(s);
		}
		System.out.println();
		//集合遍历方法2 普通for
		for(int i=0;i<list.size();++i) {
			System.out.print(list.get(i));
		}
		System.out.println();
		//集合遍历方法3 迭代器遍历
		for(Iterator<String> it=list.iterator();it.hasNext();) {
			System.out.print(it.next());
		}
		System.out.println();
		//集合遍历方法四 转化成数组 在遍历
		String[] arrayStr=new String[list.size()];
		list.toArray(arrayStr);
		for(String s:arrayStr) {
			System.out.print(s);
		}
		System.out.println();
		
		LinkedList<String> linkedList=new LinkedList<>(list);
		for(String s :linkedList) {
			System.out.print(s);
		}
		System.out.println();
		
		for(Iterator<String> it = linkedList.iterator();it.hasNext();) {
			System.out.print(it.next());
		}
		System.out.println();
		
		//Map遍历
		
		Map<String,day> map=new HashMap<>();
		map.put("星期一",day.monday);
		map.put("星期二",day.tueday);
		map.put("星期三",day.wednesday);
		map.put("星期四",day.thursday);
		map.put("星期五",day.friday);
		map.put("星期六",day.saturday);
		map.put("星期七",day.sunday);
		
		//只输出map的values
		for(day d:map.values()) {
			System.out.print(d);
		}
		System.out.println();
		//使用增强for遍历map，输出key--> value 
		for(Entry<String,day> entry: map.entrySet()) {
			System.out.print(entry.getKey()+" "+entry.getValue());
		}
		System.out.println();
		//使用iterator遍历，输出key-->value
		for(Iterator<Entry<String, day>> it = map.entrySet().iterator();it.hasNext();) {
			Entry<String,day> element=it.next();
			System.out.print(element.getKey()+" "+element.getValue());
		}
		System.out.println();
	}
}
