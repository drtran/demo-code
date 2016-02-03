package com.bemach.aep.fitnesse.pisentry;

import javax.inject.Inject;

import org.apache.deltaspike.cdise.api.CdiContainer;

import com.bemach.aep.pisentry.event.UdpSender;

public class PiSentryReceiverTest {
	public String data;
	
	private String eventId;
	private String eventType;
	private String eventMessage;
	
	@Inject private UdpSender sender;

	private CdiContainer cdiContainer;

	private PiSentryReceiverTest target;
	
	public void process() {
		
		sender.sendTo(data, "localhost", 9999);
	}
	
	public String eventId() {
		return eventId;
	}
	
}
