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
	public void shouldNotGenerateAlarmWhenUnArmedAndReceivedFaultEvent() {
		Event fault = Mockito.mock(Event.class);
		Mockito.when(fault.getType()).thenReturn(EventType.FAULT);
		target.process(fault);
		State state = target.getState(); 
		assertNotEquals(State.ALARMED, state);
	}
	
	@Test
	public void shouldGenerateAlarmWhenArmedAndReceivedFaultEvent() {
		Event fault = Mockito.mock(Event.class);
		Event arm = Mockito.mock(Event.class);
		Mockito.when(arm.getType()).thenReturn(EventType.ARM_AWAY);
		Mockito.when(fault.getType()).thenReturn(EventType.FAULT);
		target.process(arm);
		target.process(fault);
		State state = target.getState(); 
		assertEquals(State.ALARMED, state);
	}
	
	
}
