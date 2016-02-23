package com.bemach.aep.pisentry.event;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bemach.aep.pisentry.vos.Event;

@RunWith(MockitoJUnitRunner.class)
public class UdpEventSenderTest {

	@BeforeClass
	public static void setUp() {
		Logger.getRootLogger().setLevel(Level.OFF);
	}

	/**
	 * Spying on the sender - verifying its behavior but not specific 
	 * indrect output
	 * 
	 */
	@Test
	public void shouldCallUdpSender() {
		UdpSender udpSender = Mockito.spy(UdpSender.class);
		Event event = Mockito.mock(Event.class);
		UdpEventSender target = new UdpEventSender();
		target.setUdpSender(udpSender);

		target.send(event);

		Mockito.verify(udpSender).sendTo(Mockito.anyString());
	}
	
	/**
	 * Spying on the sender - verifying its behavior.
	 */
	@Test
	public void shouldSendCorrectEvent() {
		UdpSender udpSender = Mockito.spy(UdpSender.class);
		Event event = new Event("TESTID:FAULT:EVENT_DATA");
		UdpEventSender target = new UdpEventSender();
		target.setUdpSender(udpSender);

		target.send(event);

		Mockito.verify(udpSender).sendTo("TESTID:FAULT:EVENT_DATA");
	}
	
}
