package com.bemach.aep.pisentry.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bemach.aep.pisentry.utils.TestUtis;
import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;

@RunWith(CdiRunner.class)
@ActivatedAlternatives({MockUdpReceiver.class})
public class UdpEventReceiverTest {
	
	@Inject private UdpEventReceiver target;
	private Event event;
	
	@Test
	public void should_receive_a_udp_message() {
		TestUtis.put("MOCKUDPRECEIVER", "");
		
		Event actual = target.receive();
		
		assertNotNull(actual);
	}
	
	
	// CDI UNIT prevents the use of Parameters (native or JUnitParameters).
	@Test
	public void should_receive_a_fault_udp_message() {
		TestUtis.put("MOCKUDPRECEIVER", "ZONE57:FAULT:57.BUTTONA");
		
		Event actual = target.receive();
		
		assertEquals("ZONE57", actual.getId());
		assertEquals(EventType.FAULT, actual.getType());
		assertEquals("57.BUTTONA", actual.getMessage());
	}
	
	@Test
	public void should_receive_an_arm_udp_message() {
		TestUtis.put("MOCKUDPRECEIVER", "USER123:ARM_AWAY:NOOP");
		
		Event actual = target.receive();
		
		assertEquals("USER123", actual.getId());
		assertEquals(EventType.ARM_AWAY, actual.getType());
		assertEquals("NOOP", actual.getMessage());
	}
}
