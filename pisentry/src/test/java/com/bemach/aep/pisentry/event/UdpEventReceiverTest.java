package com.bemach.aep.pisentry.event;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.bemach.aep.pisentry.vos.Event;

@RunWith(MockitoJUnitRunner.class)
public class UdpEventReceiverTest {
	@BeforeClass
	public static void setUp() {
		Logger.getRootLogger().setLevel(Level.OFF);
	}

	/**
	 * Spying on UdpEventReceiver - Verifying its behavior.
	 * 
	 */
	@Test
	public void shouldCallUdpReceiver() {
		// Arrange
		UdpReceiver udpReceiver = Mockito.mock(UdpReceiver.class);
		Mockito.when(udpReceiver.receive()).thenReturn("TESTID:FAULT:EVENT_DATA");
		UdpEventReceiver target = new UdpEventReceiver();
		target.setUdpReceiver(udpReceiver);

		// Act
		target.receive();

		// Assert
		Mockito.verify(udpReceiver).receive();
	}
	
	/**
	 * Stubbing the DOC - injecting indirect input to SUT
	 */
	@Test
	public void shouldReceiveAnEvent() {
		// Arrange
		UdpReceiver udpReceiver = Mockito.mock(UdpReceiver.class);
		Mockito.when(udpReceiver.receive()).thenReturn("TESTID:FAULT:EVENT_DATA");
		UdpEventReceiver target = new UdpEventReceiver();
		target.setUdpReceiver(udpReceiver);
		Event expected = new Event("TESTID:FAULT:EVENT_DATA");

		// Act
		Event actual = target.receive();

		// Assert
		assertThat(actual, equalTo(expected));
	}
}
