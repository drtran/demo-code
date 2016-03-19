package com.bemach.aep.utility.refactoring;

import javax.ws.rs.core.Response;

import com.bemach.aep.pisentry.event.UdpEventSender;

public interface MyExtractInterface {

	Response getStatus();

	void armAway();

	void armHome();

	void disarm();

	UdpEventSender getUdpEventSender();

	void setEventSender(UdpEventSender eventSender);

}
