package com.bemach.aep.pisentry.event;

import javax.inject.Inject;

import com.bemach.aep.pisentry.state.StateManager;
import com.bemach.aep.pisentry.vos.Event;

public class EventProcessorImpl implements EventProcessor {

	@Inject private StateManager stateMgr;
	
	@Inject private EventReceiver eventRcvr;

	private Event event;
	
	public void process() {
		event = eventRcvr.receive();
	}

	public StateManager getStateManager() {
		return stateMgr;
	}

	public Event getEvent() {
		return event;
	}

}
