package com.bemach.aep.pisentry.event;

import com.bemach.aep.pisentry.vos.Event;

public class UdpEventSender implements EventSender {
	private UdpSender sender;

	public void setUdpSender(UdpSender sender) {
		this.sender = sender;
	}

	public void send(Event event) {
		sender.sendTo(event.toString());
	}

}
