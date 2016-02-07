package com.bemach.aep.pisentry.event;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bemach.aep.pisentry.state.NotificationManager;
import com.bemach.aep.pisentry.state.StateManager;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;
import com.bemach.aep.pisentry.zone.ZoneManager;

@RunWith(MockitoJUnitRunner.class)
public class EventProcessorImplTest {

	private ZoneManager zoneMgr;
	private StateManager stateMgr;
	private EventProcessorImpl target;
	private Event event;
	private NotificationManager notificationMgr;

	@Before
	public void setUp() {
		zoneMgr = Mockito.mock(ZoneManager.class);
		stateMgr = Mockito.mock(StateManager.class);
		notificationMgr = Mockito.mock(NotificationManager.class);
		target = new EventProcessorImpl();
		target.setZoneMgr(zoneMgr);
		target.setStateMgr(stateMgr);
		target.setNotificationMgr(notificationMgr);

		event = Mockito.mock(Event.class);
	}

	@Test
	public void shouldCallZoneManager() {
		Mockito.when(event.getType()).thenReturn(EventType.NOFAULT);

		target.process(event);

		Mockito.verify(zoneMgr, Mockito.times(1)).process(event);
	}

	@Test
	public void shouldNotCallZoneManager() {
		Mockito.when(event.getType()).thenReturn(EventType.ARM_AWAY);

		target.process(event);

		Mockito.verify(zoneMgr, Mockito.times(0)).process(event);
	}

	@Test
	public void shouldCallStateManager() {
		Mockito.when(event.getType()).thenReturn(EventType.ARM_AWAY);

		target.process(event);

		Mockito.verify(stateMgr, Mockito.times(1)).process(event);
	}

	@Test
	public void shouldCallNotificationManager() {
		Mockito.when(event.getType()).thenReturn(EventType.NOTIFY);

		target.process(event);

		Mockito.verify(notificationMgr, Mockito.times(1)).notify(event);
	}

	@Test
	public void shouldNotCallAnyManager() {
		Mockito.when(event.getType()).thenReturn(null);

		target.process(event);

		Mockito.verify(notificationMgr, Mockito.times(0)).notify(event);
		Mockito.verify(zoneMgr, Mockito.times(0)).process(event);
		Mockito.verify(stateMgr, Mockito.times(0)).process(event);
	}
}
