package com.bemach.aep.pisentry.event;

import javax.inject.Inject;

import com.bemach.aep.pisentry.state.StateManager;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;

public class EventProcessorImpl implements EventProcessor {

	@Inject private StateManager stateMgr;
	
	//	@Inject private EventReceiver eventRcvr;

	private Event event;
	
	public void process(Event event) {
		this.event = event;
		if (event.getType() == EventType.FAULT ||
			event.getType() == EventType.ARM_AWAY ||
			event.getType() == EventType.ARM_HOME ||
			event.getType() == EventType.DISARM) {
			stateMgr.process(event);
		} else if (event.getType() == EventType.NOTIFY) {
			System.out.println("UNSUPPORTED Event Type " + event.getType());
		} else {
			System.out.println("UNSUPPORTED Event Type " + event.getType());
		}
	}

	public StateManager getStateManager() {
		return stateMgr;
	}

	public Event getEvent() {
		return event;
	}

}
