package com.bemach.aep.pisentry.state;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.State;

public interface StateManager {

	public void process(Event fault);
	public State getState();
}
