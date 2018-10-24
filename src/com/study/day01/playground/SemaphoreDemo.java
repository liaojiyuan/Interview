package com.study.day01.playground;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *@author gcc
 *@date 2018年10月24日 下午3:40:33
 *@description 创建跑道启动程序
*/
public class SemaphoreDemo {
	//学生类
	static class Student implements Runnable{
		
		private int num; //学生数量
		private PlayGround palyground;
		
		public Student(int num, PlayGround palyground) {
			super();
			this.num = num;
			this.palyground = palyground;
		}

		@Override
		public void run() {
			try {
				//获取跑道
				PlayGround.Track track=palyground.acquireTrack();
				if(null != track) {
					System.out.println("学生"+num+"在"+track.toString()+"跑道上跑步");
					TimeUnit.SECONDS.sleep(2);
					System.out.println("学生"+num+"释放"+track.toString()+"跑道");
					//释放跑道
					palyground.releaseTrack(track);
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Executor executor=Executors.newCachedThreadPool();
		PlayGround playground=new PlayGround();
		for (int i = 0; i < 10; i++) {
			executor.execute(new Student(i+1,playground));
		}
	}
}
