package com.bemach.aep.utility.refactoring;

import javax.ws.rs.core.Response;

import com.bemach.aep.pisentry.event.UdpEventSender;
import com.bemach.aep.pisentry.vos.EventType;

public class ExtractInterface implements MyExtractInterface {
	public Response getStatus() {
		return null;
	}

	public void armAway() {
		sendEvent(EventType.ARM_AWAY, "Arming Away ...");
	}

	public void armHome() {
		sendEvent(EventType.ARM_HOME, "Arming Home ...");
	}

	public void disarm() {
		sendEvent(EventType.DISARM, "Disarming ...");
	}

	public UdpEventSender getUdpEventSender() {
		return null;
	}

	public void setEventSender(UdpEventSender eventSender) {
	}

	private void sendEvent(EventType type, String data) {
	}
}
