package com.bemach.aep.solid.isp.refactored.inheritance;

import java.util.Timer;

public class TimedDoor implements Door, TimerClient {

	private TimeoutTask task;

	public TimedDoor() {
		task = new TimeoutTask();
		task.register(this);
		Timer timer = new Timer();
		timer.schedule(task, 1000, 5000);
	}

	public void lock() {
		System.out.println(this.getClass().getName() + ": locks.");
	}

	public void unlock() {
		System.out.println(this.getClass().getName() + ": unlocks.");
	}

	public void isDoorOpen() {
		System.out.println(this.getClass().getName() + ": opens.");
	}

	public void timeout() {
		System.out.println(this.getClass().getName() + ": times out ...");
	}

}
