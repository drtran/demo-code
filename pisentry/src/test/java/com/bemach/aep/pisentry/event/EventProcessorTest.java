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
@ActivatedAlternatives(MockStateManager.class)
public class EventProcessorTest {

	@Inject private EventProcessorImpl target;

	@Mock private EventReceiver receiver;
	
	@Mock private Event event;

	@Test
	public void should_process_an_event() {
		when(receiver.receive()).thenReturn(event);
		target.process();
		assertEquals(State.ALARMED, target.getStateManager().getState());
	}
}
