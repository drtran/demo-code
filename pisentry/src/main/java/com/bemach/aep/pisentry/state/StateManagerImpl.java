package com.bemach.aep.pisentry.state;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.Notification;
import com.bemach.aep.pisentry.vos.State;

public class StateManagerImpl implements StateManager {

	private State state = State.UNARMED;
	private NotificationManager notifier;

	public StateManagerImpl(NotificationManager notifier) {
		this.notifier = notifier;
	}

	public void process(Event event) {
		switch (event.getType()) {
		case FAULT:
			if (state == State.ARMED_AWAY) {
				state = state.ALARMED;
			}
			notify(State.ARMED_AWAY.toString(), State.ALARMED.toString());
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

	private void notify(String armedAway, String alarmed) {
		notifier.notify(new Notification());
	}

	public State getState() {
		return state;
	}

}
