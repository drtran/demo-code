package com.bemach.aep.pisentry.event;

import javax.inject.Inject;

import com.bemach.aep.pisentry.state.StateManager;

public class EventProcessorImpl implements EventProcessor {

	@Inject private StateManager stateMgr;
	
	@Inject private EventReceiver eventRcvr;
	
	public void process() {
	}

	public StateManager getStateManager() {
		return stateMgr;
	}

}
