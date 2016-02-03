package com.bemach.aep.pisentry.event;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.bemach.aep.pisentry.state.MockStateManager;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.State;


@RunWith(CdiRunner.class)
@ActivatedAlternatives({MockStateManager.class, MockEventReceiver.class})
public class EventProcessorTest {

	@Inject private EventProcessorImpl target;

	@Mock private Event event;

	@Test
	public void should_process_an_event() {
		System.setProperty("MOCKSTATEMANAGER", State.ALARMED.toString());
		target.process();
		assertEquals(State.ALARMED, target.getStateManager().getState());
	}
	
	@Test
	public void should_process_an_arm_away_event() {
		System.setProperty("MOCKSTATEMANAGER", State.ARMED_AWAY.toString());
		target.process();
		assertEquals(State.ARMED_AWAY, target.getStateManager().getState());
	}
}
