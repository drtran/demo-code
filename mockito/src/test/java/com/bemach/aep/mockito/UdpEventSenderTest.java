package com.bemach.aep.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UdpEventSenderTest {

	private static final String EVENT_GENERIC = "TESTID:FAULT:EVENT_DATA";

	/** 
	 * Spying on the sender - verifying its behavior but not specific indrect
	 * output
	 * 
	 */
	@Test
	public void shouldSendAnyString() {
		UdpSender theSpy = Mockito.spy(UdpSender.class);
		Event event = Mockito.mock(Event.class);
		UdpEventSender target = new UdpEventSender();
		target.setUdpSender(theSpy);

		target.send(event);

		Mockito.verify(theSpy).sendTo(Mockito.anyString());
	}
	
	/**
	 * Spying on the sender - verifying its behavior.
	 */
	@Test
	public void shouldSendCorrectEvent() {
		UdpSender udpSender = Mockito.spy(UdpSender.class);
		Event event = new Event(EVENT_GENERIC);
		UdpEventSender target = new UdpEventSender();
		target.setUdpSender(udpSender);

		target.send(event);

		Mockito.verify(udpSender).sendTo(EVENT_GENERIC);
	}
	
}
