package com.bemach.aep.solid.isp.refactored.delegate;

import java.util.TimerTask;

public class TimeoutTask extends TimerTask {

	private TimerClient client;

	public void register(TimerClient client) {
		this.client = client;
	}

	@Override
	public void run() {
		client.timeout();
	}

}
