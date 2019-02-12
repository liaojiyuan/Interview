package com.study.day05;
/**
* @author gaochaochao
* @date 2019年02月11日 下午4:32:34
* @description 实现一个大小固定的有序数组，支持动态增删改操作
*/

public class FixedSortArray {
	private static final int DEFAULT_CAPACITY=16; //固定容量16
	private int size;
	private int[] array;
	//固定容量初始化大小
	public FixedSortArray(){
		this.array=new int[DEFAULT_CAPACITY];
		this.size=0;
	}
	//有序数组插入元素
	public void insert(int value){
		if(this.size>DEFAULT_CAPACITY){
			System.out.println("容量已满，不支持插入了");
			return ;
		}
		int result=binarySearch(value);
		insert(result+1,value);
		++this.size;
	}
	//二分查找
	private int binarySearch(int value) {
		int lo=0,hi=this.size;
		int mid=0;
		while(lo<hi){
			if(value<this.array[mid]){
				hi=mid;
			}else{
				lo=mid+1;
			}
		}
		return --lo;
	}
 
	private void insert(int index,int value){ //确保index有效性 0<=index<DEFULT_CAPACITY
		 for(int i=this.size;i>index;i--){
			 this.array[i]=this.array[i-1];
		 }
		 this.array[index]=value;
	}
	 // 查找
	public void search(int value){
		int result=search0(value);
		if(result<0){
			System.out.println("不存在");
		}else{
			System.out.println("查找成功");
		}
	}
	//搜索
	private int search0(int value){
		int result=binarySearch(value);
		if(value==this.array[result]){
			return result;
		}
		return -result;
	}
	
	//删除
	public void remove(int value){
		int index=search0(value);
		if(index<0){
			System.out.println("删除失败，该元素不存在");
			return ;
		}
		for(int i=index+1;i<this.size;i++){
			this.array[i-1]=this.array[i];
		}
		this.size--;
	}
	//批量删除指定的重复相同元素
	public int removeAll(int value){
		int endIndex=search0(value);
		if(endIndex<0){
			System.out.println("删除失败，该元素不存在");
			return 0;
		}
		int startIndex=0;
		while(startIndex<endIndex){ //找寻重复元素的始末位置
			if(value==this.array[startIndex]){
				break;
			}
			startIndex++;
		}
		for(int i=startIndex+1;i<this.size;i++){
			this.array[i-1]=this.array[i];
		}
		int count=endIndex-startIndex+1;
		this.size-=count;
		return count;
	}
	//修改，并重新有序
	public void update(int oldValue,int newValue){
		int index=search0(oldValue);
		if(index<0){
			System.out.println("不存在");
			return ;
		}
		int count=removeAll(oldValue);
		insertValueForMultiTimes(newValue,count);
	}
	//重复插入一个元素多次
	private void insertValueForMultiTimes(int newValue, int count){
		int index=binarySearch(newValue);
		for(int i=this.size+count-1;i>index;i++){
			this.array[i]=this.array[i-count];
		}
	}
}
