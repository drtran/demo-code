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

	@Test
	public void shouldCallUdpSender() {
		UdpSender udpSender = Mockito.mock(UdpSender.class);
		Event event = Mockito.mock(Event.class);
		UdpEventSender target = new UdpEventSender();
		target.setUdpSender(udpSender);

		target.send(event);

		Mockito.verify(udpSender).sendTo(Mockito.anyString());
	}
}
