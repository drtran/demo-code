package com.bemach.aep.pisentry.event;

import com.bemach.aep.pisentry.state.StateManager;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;
import com.bemach.aep.pisentry.zone.ZoneManager;

public class EventProcessorImpl implements EventProcessor {

	private StateManager stateMgr;
	private ZoneManager zoneMgr;

	public void setZoneMgr(ZoneManager zoneMgr) {
		this.zoneMgr = zoneMgr;
	}

	public void setStateMgr(StateManager stateMgr) {
		this.stateMgr = stateMgr;
	}

	private Event event;

	public void process(Event event) {
		this.event = event;
		if (event.getType() == EventType.NOTIFY) {
			System.out.println("UNSUPPORTED Event Type " + event.getType());
		} else if (isStateRelatedEvent(event)) {
			stateMgr.process(event);
			if (isZoneRelatedEvent(event)) {
				zoneMgr.process(event);
			}
		} else {
			System.out.println("UNSUPPORTED Event Type " + event.getType());
		}
	}

	private boolean isZoneRelatedEvent(Event event2) {
		return event.getType() == EventType.FAULT || event.getType() == EventType.NOFAULT;
	}

	private boolean isStateRelatedEvent(Event event) {
		return event.getType() == EventType.FAULT || event.getType() == EventType.NOFAULT
				|| event.getType() == EventType.ARM_AWAY || event.getType() == EventType.ARM_HOME
				|| event.getType() == EventType.DISARM;
	}

	public StateManager getStateManager() {
		return stateMgr;
	}

	public Event getEvent() {
		return event;
	}

}
