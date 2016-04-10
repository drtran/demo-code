package com.bemach.aep.pisentryweb.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bemach.aep.pisentry.event.UdpEventSender;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;

@RunWith(MockitoJUnitRunner.class)
public class AlarmManager2BRefactoredTest {

	/**
	 * Mocking a DOC - verifying the indirect output from SUT.
	 * 
	 */
	@Test
	public void shouldDisarmWithCorrectEvent() {
		// Arrange
		AlarmManager2BRefactored alarmMgr = new AlarmManager2BRefactored();
		UdpEventSender mockEventSender = Mockito.mock(UdpEventSender.class);
		alarmMgr.setEventSender(mockEventSender);
		ArgumentCaptor<Event> argument = ArgumentCaptor.forClass(Event.class);
		Event expected = new Event(AlarmManager2BRefactored.class.toString(), EventType.DISARM, "NOOP");

		// Act
		alarmMgr.disarm();

		// Assert
		Mockito.verify(mockEventSender).send(argument.capture());
		Event actual = argument.getValue();
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void shouldArmAwayCorrectEvent() {
		// Arrange
		AlarmManager2BRefactored alarmMgr = new AlarmManager2BRefactored();
		UdpEventSender mockEventSender = Mockito.mock(UdpEventSender.class);
		alarmMgr.setEventSender(mockEventSender);
		ArgumentCaptor<Event> argument = ArgumentCaptor.forClass(Event.class);
		Event expected = new Event(AlarmManager2BRefactored.class.toString(), EventType.ARM_AWAY, "NOOP");

		// Act
		alarmMgr.armAway();

		// Assert
		Mockito.verify(mockEventSender).send(argument.capture());
		Event actual = argument.getValue();
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void shouldArmHomeCorrectEvent() {
		// Arrange
		AlarmManager2BRefactored alarmMgr = new AlarmManager2BRefactored();
		UdpEventSender mockEventSender = Mockito.mock(UdpEventSender.class);
		alarmMgr.setEventSender(mockEventSender);
		ArgumentCaptor<Event> argument = ArgumentCaptor.forClass(Event.class);
		Event expected = new Event(AlarmManager2BRefactored.class.toString(), EventType.ARM_HOME, "NOOP");

		// Act
		alarmMgr.armHome();

		// Assert
		Mockito.verify(mockEventSender).send(argument.capture());
		Event actual = argument.getValue();
		assertThat(actual, equalTo(expected));
	}
}
