package com.bemach.aep.solid.isp;

import java.util.Timer;

public class Main {

	public static void main(String[] args) {
		System.out.println("Begins...");

		TimedDoor timedDoor = new TimedDoor();
		TimeoutTask task = new TimeoutTask();
		task.register(timedDoor);
		Timer timer = new Timer();

		timer.schedule(task, 1000, 5000);

		System.out.println("Timer runs ... ");
	}

}
