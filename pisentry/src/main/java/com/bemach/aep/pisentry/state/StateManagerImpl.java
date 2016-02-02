package com.bemach.aep.pisentry.state;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.State;

public class StateManagerImpl implements StateManager {

	private State state = State.UNARMED;

	public void process(Event event) {
		switch (event.getType()) {
		case FAULT:
			if (state == State.ARMED_AWAY) {
				state = state.ALARMED;
			}
			break;
		case ARM_AWAY:
			state = State.ARMED_AWAY;
			break;
		case DISARM:
			state = State.UNARMED;
			break;
		default:
			break;
		}
	}

	public State getState() {
		return state;
	}

}
