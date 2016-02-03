package com.bemach.aep.pisentry.event;

import com.bemach.aep.pisentry.state.StateManager;

public interface EventProcessor {
	public void process();

	public StateManager getStateManager();
}
