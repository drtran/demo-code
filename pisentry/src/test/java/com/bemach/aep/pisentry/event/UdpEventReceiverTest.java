package com.bemach.aep.pisentry.event;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bemach.aep.pisentry.utils.TestUtis;
import com.bemach.aep.pisentry.vos.Event;

@RunWith(CdiRunner.class)
@ActivatedAlternatives({MockUdpReceiver.class})
public class UdpEventReceiverTest {
	@Inject private UdpEventReceiver target;
	private Event event;
	
	@Test
	public void should_receive_a_udp_message() {
		TestUtis.put("MOCKUDPRECEIVER", "ZONE57:FAULT:57.BUTTONA");
		Event actual = target.receive();
		assertNotNull(actual);
	}
	
}
