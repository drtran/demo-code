package com.bemach.aep.mockito;


public class UdpEventSender implements EventSender {
	private UdpSender sender;

	public void setUdpSender(UdpSender sender) {
		this.sender = sender;
	}

	public void send(Event event) {
		sender.sendTo(event.toString());
	}

}
