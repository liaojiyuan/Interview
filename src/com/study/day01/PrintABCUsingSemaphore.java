package com.study.day01;

import java.util.concurrent.Semaphore;

/**
 *@author gcc
 *@date 2018年10月24日 上午10:33:40
 *@description
*/
public class PrintABCUsingSemaphore {
	private int times;//打印次数
	private Semaphore semaphoreA=new Semaphore(1);
	private Semaphore semaphoreB=new Semaphore(0);
	private Semaphore semaphoreC=new Semaphore(0);
	
	public PrintABCUsingSemaphore(int times) {
		super();
		this.times = times;
	}
	
	public static void main(String [] args) {
		PrintABCUsingSemaphore instance=new PrintABCUsingSemaphore(10);
		//lambda表达式   函数描述符
		new Thread(()->instance.printA()).start();
		//方法引用   函数描述符
		new Thread(instance::printB).start();
		// 匿名内部类
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
		for(int i=0;i<times;i++) {
			current.acquire();
			System.out.print(name);
			next.release();
		}
	}
	
	
}