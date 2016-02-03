package com.bemach.aep.pisentry.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.bemach.aep.pisentry.state.MockStateManager;
import com.bemach.aep.pisentry.utils.TestUtis;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;
import com.bemach.aep.pisentry.vos.State;


@RunWith(CdiRunner.class)
@ActivatedAlternatives({MockStateManager.class, MockEventReceiver.class})
public class EventProcessorTest {

	@Inject private EventProcessorImpl target;

	@Mock private Event event;

	@Test
	public void should_receive_an_event() {
		when(event.getType()).thenReturn(EventType.FAULT);
		TestUtis.put("MOCKEVENTRECEIVER", event);
		target.process();
		assertNotNull(target.getEvent());
	}
	
	@Test
	public void should_receive_a_fault_event() {
		when(event.getType()).thenReturn(EventType.FAULT);
		TestUtis.put("MOCKEVENTRECEIVER", event);
		target.process();
		assertEquals(EventType.FAULT, target.getEvent().getType());
	}
	
	@Test
	public void should_process_an_event() {
		when(event.getType()).thenReturn(EventType.FAULT);
		TestUtis.put("MOCKEVENTRECEIVER", event);
		System.setProperty("MOCKSTATEMANAGER", State.ALARMED.toString());
		target.process();
		assertEquals(State.ALARMED, target.getStateManager().getState());
	}
	
	@Test
	public void should_process_an_arm_away_event() {
		when(event.getType()).thenReturn(EventType.FAULT);
		TestUtis.put("MOCKEVENTRECEIVER", event);
		System.setProperty("MOCKSTATEMANAGER", State.ARMED_AWAY.toString());
		target.process();
		assertEquals(State.ARMED_AWAY, target.getStateManager().getState());
	}
}
