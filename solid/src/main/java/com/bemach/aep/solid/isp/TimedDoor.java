package com.bemach.aep.solid.isp;

public class TimedDoor implements Door {

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
		System.out.println(this.getClass().getName() + ": times out.");
	}

}
