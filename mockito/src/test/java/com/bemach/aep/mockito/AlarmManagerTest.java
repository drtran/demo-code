package com.bemach.aep.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlarmManagerTest {

	/**
	 * Mocking a DOC - verifying the indirect output from SUT.
	 * 
	 */
	@Test
	public void shouldDisarmWithCorrectEvent() {
		// Arrange
		AlarmManager alarmMgr = new AlarmManager();
		UdpEventSender theMock = Mockito.mock(UdpEventSender.class);
		alarmMgr.setEventSender(theMock);
		ArgumentCaptor<Event> argument = ArgumentCaptor.forClass(Event.class);
		Event expected = new Event(AlarmManager.class.toString(), EventType.DISARM, "NOOP");

		// Act
		alarmMgr.disarm();

		// Assert
//		Mockito.verify(theMock, Mockito.times(1)).send(argument.capture());
		Mockito.verify(theMock).send(argument.capture());
		Event actual = argument.getValue();
		assertThat(actual, equalTo(expected));
	}

}
