package com.bemach.aep.pisentry.state;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.State;

@Alternative @Default
public class MockStateManager implements StateManager {
	
	public void process(Event fault) {
	}

	public State getState() {
		return State.valueOf(System.getProperty("MOCKSTATEMANAGER"));
	}

}
