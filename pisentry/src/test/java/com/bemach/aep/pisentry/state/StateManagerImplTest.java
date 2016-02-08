package com.bemach.aep.pisentry.state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bemach.aep.pisentry.vos.State;

public class StateManagerImplTest {
	private StateManagerImpl target;

	@Test
	public void shouldBeUnarmedWhenStarted() {
		target = StateManagerImpl.getInstance();
		assertEquals(State.UNARMED, target.getState());
	}
}
