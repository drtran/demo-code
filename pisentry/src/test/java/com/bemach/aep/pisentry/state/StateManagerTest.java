package com.bemach.aep.pisentry.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;
import com.bemach.aep.pisentry.vos.Notification;
import com.bemach.aep.pisentry.vos.State;

@RunWith(MockitoJUnitRunner.class)
public class StateManagerTest {
	
	private StateManager target;
	
	@Mock private Event arm;

	@Mock private NotificationManager notifier;

	@Mock private Notification msg;

	@Mock private Event fault;

	@Mock private Event disarm;

	@Before
	public void setUp() {
		msg = mock(Notification.class);
		target = new StateManagerImpl(notifier);
	}
	
	@Test
	public void should_stay_unarmed_when_unarmed_and_get_fault() {
		when(fault.getType()).thenReturn(EventType.FAULT);
		
		target.process(fault);
		
		State state = target.getState(); 
		assertNotEquals(State.ALARMED, state);
	}
	
	@Test
	public void should_become_alarmed_when_armed_away_and_get_fault_event() {
		when(arm.getType()).thenReturn(EventType.ARM_AWAY);
		when(fault.getType()).thenReturn(EventType.FAULT);
		target.process(arm);
		
		target.process(fault);
		
		State state = target.getState(); 
		assertEquals(State.ALARMED, state);
	}
	
	@Test 
	public void should_become_unarmed_when_armed_away_and_get_disarm_event() {
		when(arm.getType()).thenReturn(EventType.ARM_AWAY);
		when(disarm.getType()).thenReturn(EventType.DISARM);
		target.process(arm);
		
		target.process(disarm);
		
		State state = target.getState(); 
		assertEquals(State.UNARMED, state);
	}
	
	@Test
	public void should_notify_when_state_changes() {
		when(arm.getType()).thenReturn(EventType.ARM_AWAY);
		when(disarm.getType()).thenReturn(EventType.DISARM);

		target.process(arm);
		
		verify(notifier, times(1)).notify(any(Notification.class));
	}
}
