package com.bemach.aep.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UdpEventReceiverTest {

	/**
	 * Spying on UdpEventReceiver - Verifying its behavior.
	 * 
	 */
	@Test
	public void shouldCallReceiveMethod() {
		// Arrange
		UdpReceiver theStub = Mockito.mock(UdpReceiver.class);
		when(theStub.receive()).thenReturn("TESTID:FAULT:EVENT_DATA");
		UdpEventReceiver target = new UdpEventReceiver();
		target.setUdpReceiver(theStub);

		// Act
		target.receive();

		// Assert
		verify(theStub).receive();
	}

	/**
	 * Stubbing the DOC - injecting indirect input to SUT
	 */
	@Test
	public void shouldReceiveOneCorrectEvent() {
		// Arrange
		UdpReceiver theStub = Mockito.mock(UdpReceiver.class);
		when(theStub.receive()).thenReturn("TESTID:FAULT:EVENT_DATA");
		UdpEventReceiver target = new UdpEventReceiver();
		target.setUdpReceiver(theStub);
		Event expected = new Event("TESTID:FAULT:EVENT_DATA");

		// Act
		Event actual = target.receive();

		// Assert
		assertThat(actual, equalTo(expected));
	}
}
