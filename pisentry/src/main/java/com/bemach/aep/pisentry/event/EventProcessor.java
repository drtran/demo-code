package com.bemach.aep.pisentry.event;

import com.bemach.aep.pisentry.state.StateManager;
import com.bemach.aep.pisentry.vos.Event;

public interface EventProcessor {
	public void process(Event event);

	public StateManager getStateManager();
}
