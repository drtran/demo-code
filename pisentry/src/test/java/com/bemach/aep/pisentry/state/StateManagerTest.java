package com.bemach.aep.pisentry.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;
import com.bemach.aep.pisentry.vos.State;

public class StateManagerTest {
	
	private StateManager target;
	
	@Mock
	private Event arm;

	@Before
	public void setUp() {
		target = new StateManagerImpl();
	}
	
	@Test
	public void should_stay_unarmed_when_unarmed_and_get_fault() {
		Event fault = Mockito.mock(Event.class);
		Mockito.when(fault.getType()).thenReturn(EventType.FAULT);
		
		target.process(fault);
		
		State state = target.getState(); 
		assertNotEquals(State.ALARMED, state);
	}
	
	@Test
	public void should_become_alarmed_when_armed_and_get_fault_event() {
		Event fault = Mockito.mock(Event.class);
		Event arm = Mockito.mock(Event.class);
		Mockito.when(arm.getType()).thenReturn(EventType.ARM_AWAY);
		Mockito.when(fault.getType()).thenReturn(EventType.FAULT);
		target.process(arm);
		
		target.process(fault);
		
		State state = target.getState(); 
		assertEquals(State.ALARMED, state);
	}
	
	@Test 
	public void should_become_unarmed_when_armed_and_get_disarm_event() {
		
	}
}
