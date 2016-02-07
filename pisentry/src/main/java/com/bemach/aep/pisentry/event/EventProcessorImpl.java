package com.bemach.aep.pisentry.event;

import org.apache.log4j.Logger;

import com.bemach.aep.pisentry.state.NotificationManager;
import com.bemach.aep.pisentry.state.StateManager;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;
import com.bemach.aep.pisentry.zone.ZoneManager;

public class EventProcessorImpl implements EventProcessor {
	private static Logger logger = Logger.getLogger(EventProcessorImpl.class);
	private StateManager stateMgr;
	private ZoneManager zoneMgr;
	private NotificationManager notificationMgr;

	public void setZoneMgr(ZoneManager zoneMgr) {
		this.zoneMgr = zoneMgr;
	}

	public void setStateMgr(StateManager stateMgr) {
		this.stateMgr = stateMgr;
	}

	public void process(Event event) {
		if (event.getType() == EventType.NOTIFY) {
			notificationMgr.notify(event);
		} else if (isStateRelatedEvent(event.getType())) {
			if (isZoneRelatedEvent(event.getType())) {
				zoneMgr.process(event);
			}
			stateMgr.process(event);
		} else {
			logger.error("UNSUPPORTED Event Type " + event.getType());
		}
	}

	private boolean isZoneRelatedEvent(EventType type) {
		return type == EventType.FAULT || type == EventType.NOFAULT;
	}

	private boolean isStateRelatedEvent(EventType type) {
		return type == EventType.FAULT || type == EventType.NOFAULT || type == EventType.ARM_AWAY
				|| type == EventType.ARM_HOME || type == EventType.DISARM;
	}

	public void setNotificationMgr(NotificationManager notificationMgr) {
		this.notificationMgr = notificationMgr;
	}
}
