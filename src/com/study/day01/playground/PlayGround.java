package com.study.day01.playground;

import java.util.concurrent.Semaphore;

/**
 *@author gcc
 *@date 2018年10月24日 下午3:21:49
 *@description  体育场 有5个跑道，每个跑道每次只能有一个学生在上面跑步，一旦所有跑道都在使用，后面学生需要等待，直到有一个学生不跑，让出跑道
*/
public class PlayGround {
	private static final int NUM=3;
	
	/**
	 * 跑道类
	 * @author gaochaochao
	 *
	 */
	static class Track{
		private int num;//标识哪条跑道 123或ABC跑道
		public Track(int num) {
			this.num=num;
		}
		@Override 
		public String toString() {
			return "Track["+num+"]";
		}
	}
	//体育场的各条跑道
	private static Track[] tracks=new Track[NUM] ;
	static {
		for (int i = 0; i < NUM; i++) {
			tracks[i]=new Track(i+1);
		}
	}
	private volatile boolean[] used=new boolean[NUM];//5条跑道使用情况 false为空闲  true为占用
	
	//5条跑道就是5个共享资源，且遵循先来后到，公平模式
	private Semaphore semaphore=new Semaphore(5,true);
	
	/**
	 * 获取一条跑道，先申请共享资源，如果申请到在去申请一条空闲跑道，否则就阻塞，知道有可利用的共享资源被释放才被唤醒
	 * @return
	 * @throws InterruptedException
	 */
	public Track acquireTrack() throws InterruptedException {
		semaphore.acquire(1);
		return getNextAvailableTrack();
	}
	/**
	 * 遍历跑道找到一条可用空闲跑道返回，否则返回null
	 * @return
	 */
	private Track getNextAvailableTrack() {
		for (int i = 0; i < used.length; i++) {
			if(!used[i]) {
				used[i]=true;
				return tracks[i];
			}
		}
		return null;
	}
	
	/**
	 * 释放一条跑道
	 * @param track
	 */
	public void releaseTrack(Track track) {
		if(makeAsUsed(track)) {
			semaphore.release();
		}
	}
	private boolean makeAsUsed(Track track) {
		for (int i = 0; i < tracks.length; i++) {
			if(tracks[i] == track) {
				if(used[i]) {
					used[i]=false;
					return true;
				}
			}
		}
		return false;
	}
}
