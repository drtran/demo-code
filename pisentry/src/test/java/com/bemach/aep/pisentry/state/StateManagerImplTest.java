package com.bemach.aep.pisentry.state;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;
import com.bemach.aep.pisentry.vos.State;

@RunWith(MockitoJUnitRunner.class)
public class StateManagerImplTest {
	private StateManagerImpl target = StateManagerImpl.getInstance();
	private Event event;
	private NotificationManager notificationMgr;

	@Before
	public void setUp() {
		event = Mockito.mock(Event.class);
		notificationMgr = Mockito.mock(NotificationManager.class);
		target.setNotificationManager(notificationMgr);
	}

	@Test
	public void shouldBeArmedHome() {
		Mockito.when(event.getType()).thenReturn(EventType.ARM_HOME);

		target.process(event);

		assertEquals(State.ARMED_HOME, target.getState());
	}

	@Test
	public void shouldBeArmedAway() {
		Mockito.when(event.getType()).thenReturn(EventType.ARM_AWAY);

		target.process(event);

		assertEquals(State.ARMED_AWAY, target.getState());
	}

	@Test
	public void shouldBeDisarmed() {
		Mockito.when(event.getType()).thenReturn(EventType.DISARM);

		target.process(event);

		assertEquals(State.UNARMED, target.getState());
	}

	@Test
	public void shouldNotifyWhenStateChanges() {
		Mockito.when(event.getType()).thenReturn(EventType.DISARM);
		target.process(event);
		Mockito.when(event.getType()).thenReturn(EventType.ARM_AWAY);

		target.process(event);

		Mockito.verify(notificationMgr).notify(Mockito.any(Event.class));
	}

	@Test
	public void shouldBeAlarmedWithArmedHome() {
		Mockito.when(event.getType()).thenReturn(EventType.ARM_HOME);
		target.process(event);
		Mockito.when(event.getType()).thenReturn(EventType.FAULT);

		target.process(event);

		assertEquals(State.ALARMED, target.getState());
	}

	@Test
	public void shouldBeAlarmedWithArmedAway() {
		Mockito.when(event.getType()).thenReturn(EventType.ARM_AWAY);
		target.process(event);
		Mockito.when(event.getType()).thenReturn(EventType.FAULT);

		target.process(event);

		assertEquals(State.ALARMED, target.getState());
	}
}
