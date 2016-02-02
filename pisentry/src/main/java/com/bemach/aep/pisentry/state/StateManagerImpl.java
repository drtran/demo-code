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
			notify(State.ARMED_AWAY, State.ALARMED);
			break;
		case ARM_AWAY:
			if (state != State.ARMED_AWAY) {
				notify(state, State.ARMED_AWAY);
			}
			state = State.ARMED_AWAY;
			break;
		case ARM_HOME:
			if (state != State.ARMED_HOME) {
				notify(state, State.ARMED_HOME);
			}
			state = State.ARMED_HOME;
			break;
		case DISARM:
			if (state != State.UNARMED) {
				notify(state, State.UNARMED);
			}
			state = State.UNARMED;
			break;
		default:
			break;
		}
	}

	private void notify(State armedAway, State alarmed) {
		notifier.notify(new Notification());
	}

	public State getState() {
		return state;
	}

}
