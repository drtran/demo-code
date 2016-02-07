package com.bemach.aep.pisentry.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UdpEventReceiverTest {
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
