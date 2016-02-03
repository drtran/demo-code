package com.bemach.aep.pisentry.event;

import java.util.StringTokenizer;

import javax.inject.Inject;

import com.bemach.aep.pisentry.vos.Event;
import com.bemach.aep.pisentry.vos.EventType;

public class UdpEventReceiver implements EventReceiver {

	@Inject private UdpReceiver udpReceiver;

	public Event receive() {
		String msg = udpReceiver.receive();
		StringTokenizer st = new StringTokenizer(msg, ":");

		// USER_TOKEN:EVENT_TYPE:EVENT_DATA
		String userToken = st.nextToken();
		String eventType = st.nextToken();
		String message = st.nextToken();
		
		Event event = new Event();
		event.setType(EventType.valueOf(eventType));
		event.setId(userToken);
		event.setMessage(message);
		
		return event;
	}

}
