package com.bemach.aep.pisentry.state;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;
import com.bemach.aep.pisentry.vos.State;

public class StateManagerImpl implements StateManager {

	private State state = State.UNARMED;

	public void process(Event event) {
		if (event.getType() == EventType.FAULT) {
			if (state == State.ARMED_AWAY) {
				state = state.ALARMED;
			}
		} else if (event.getType() == EventType.ARM_AWAY) {
			state = State.ARMED_AWAY;
		} else if (event.getType() == EventType.DISARM) {
			state = State.UNARMED;
		}
	}

	public State getState() {
		return state ;
	}

}
