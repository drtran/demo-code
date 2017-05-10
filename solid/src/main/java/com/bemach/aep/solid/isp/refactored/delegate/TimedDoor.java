package com.bemach.aep.solid.isp.refactored.delegate;

import java.util.Timer;

public class TimedDoor implements Door {

	private DoorTimerAdapter doorTimerAdapter;
	private TimeoutTask task;

	public TimedDoor() {
		doorTimerAdapter = new DoorTimerAdapter();
		task = new TimeoutTask();
		task.register(doorTimerAdapter);
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
}
