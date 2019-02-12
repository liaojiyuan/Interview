package com.study.day05;

import java.util.Arrays;

/**
* @author gaochaochao
* @date 2019年02月11日 下午4:32:34
* @description 动态数组 扩容 平摊复杂度O(1)
*/
public class DynamicArray {
	private static final int DEFAULT_CAPACITY=4;//默认初始化数组容量为4
	private int size;
	private int capacity;
	private int[] array;
	//给定初始容量
	public DynamicArray(int initCapacity){
		this.capacity=initCapacity;
		array=new int[this.capacity];
		size=0;
	}
	//不给定初始容量，则按照默认容量设置初始化
	public DynamicArray(){
		this(DEFAULT_CAPACITY);
	}
	//动态扩容
	private void ensureExplicitCapacity(int minCapacity){
		if(minCapacity-this.array.length>0){ //需要扩容
			this.capacity<<=1; //扩容1倍
//			int [] newArray=new int[this.capacity];
//			System.arraycopy(this.array, 0, newArray, 0, this.size);
			int [] newArray=Arrays.copyOf(this.array,this.capacity);
			this.array=newArray;
		}
	} 
	//默认添加到数组尾部
	public void add(int value){
		ensureExplicitCapacity(this.size+1);
		this.array[size++]=value;
	}
	//添加到数组指定下标位置
	public void add(int index,int value){
		rangeCheckForAdd(index);
		ensureExplicitCapacity(size+1);
		for(int i=this.size;i>index;i++){
			this.array[i]=this.array[i-1];
		}
		this.array[index]=value;
	}
	//核查下标是否有效
	private void rangeCheckForAdd(int index) {
		if(index<0 || index>this.size){
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int get( int index){
		if(index>=this.size){
			throw new IndexOutOfBoundsException();
		}
		return this.array[index];
	}
	public String toString(){
		return "DynamicArray:"+" size="+this.size+" capacity="+this.capacity;
	}
	public static void main(String[] args){
		DynamicArray arrayList=new DynamicArray();
		System.out.println(arrayList);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		System.out.println(arrayList);
		arrayList.add(5);
		System.out.println(arrayList);
	}
}
