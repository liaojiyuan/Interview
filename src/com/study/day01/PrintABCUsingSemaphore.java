package com.study.day01;

import java.util.concurrent.Semaphore;

/**
 *@author gcc
 *@date 2018年10月24日 上午10:33:40
 *@description 多线程顺序打印问题   三个线程分别打印A,B,C，要求这三个线程一起运行，打印n次，输出“ABCABCABC....”字符串              
 *     使用操作系统的信号量控制机制   Semaphore类
*/

public class PrintABCUsingSemaphore {
	private static final int TIMES=5;
	private int times;//打印次数
	private Semaphore semaphoreA=new Semaphore(1);
	private Semaphore semaphoreB=new Semaphore(0);
	private Semaphore semaphoreC=new Semaphore(0);
	
	public PrintABCUsingSemaphore(int times) {
		super();
		this.times = times;
	}
	
	public static void main(String [] args) {
		PrintABCUsingSemaphore instance=new PrintABCUsingSemaphore(TIMES);
		//lambda表达式   函数描述符   线程名称 Thread-0
		new Thread(()->instance.printA()).start(); 
		//方法引用   函数描述符 线程名称 Thread-1
		new Thread(instance::printB).start();
		// 匿名内部类 线程名称 Thread-2
		new Thread(new Runnable() {
			@Override
			public void run() {
				instance.printC();
			}
		}).start();;
	}
	
	public void printA() {
		try {
			print("A",semaphoreA,semaphoreB);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void printB() {
		try {
			print("B",semaphoreB,semaphoreC);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void printC() {
		try {
			print("C",semaphoreC,semaphoreA);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void print(String name,Semaphore current,Semaphore next) throws InterruptedException {
		System.out.println("before recycle:"+Thread.currentThread().getName()+"   "+name);
		for(int i=0;i<times;i++) {
			System.out.println("Entry:"+Thread.currentThread().getName()+"   "+name+"   i="+i);
			current.acquire();
			System.out.print(name);
			next.release();
			System.out.println("Exit:"+Thread.currentThread().getName()+"   "+name+"   i="+i);
		}
		System.out.println("after recycle:"+Thread.currentThread().getName()+"   "+name);
	}
	
	
}