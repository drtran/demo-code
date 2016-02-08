package com.bemach.aep.pisentry.event;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UdpEventReceiverTest {
	@BeforeClass
	public static void setUp() {
		Logger.getRootLogger().setLevel(Level.OFF);
	}

	@Test
	public void shouldCallUdpReceiver() {
		UdpReceiver udpReceiver = Mockito.mock(UdpReceiver.class);
		UdpEventReceiver target = new UdpEventReceiver();
		Mockito.when(udpReceiver.receive()).thenReturn("TESTID:FAULT:EVENT_DATA");
		target.setUdpReceiver(udpReceiver);

		target.receive();

		Mockito.verify(udpReceiver).receive();
	}
}
