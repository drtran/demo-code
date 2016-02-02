package com.bemach.aep.pisentry.state;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.State;

public class GeneratesAlarmTest {
	
	private GeneratesState target;
	private Event fault;

	@Before
	public void setUp() {
		target = new GeneratesState();
	}
	
	@Test
	public void shouldGeneratesAlarmWhenArmedAndReceivedFaultEvent() {
		target.process(fault);
		State state = target.getState();
		assertEquals(State.ALARMED, state);
	}
}
