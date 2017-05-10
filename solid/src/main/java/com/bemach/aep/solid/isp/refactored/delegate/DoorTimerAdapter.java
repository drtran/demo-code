package com.bemach.aep.solid.isp.refactored.delegate;

public class DoorTimerAdapter implements TimerClient {

	public void timeout() {
		System.out.println(this.getClass().getName() + ": times out ...");
	}

}
