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

		Event event = new Event();
		// USER_TOKEN:EVENT_TYPE:EVENT_DATA
		if (st.countTokens() == 3) {
			String userToken = st.nextToken();
			String eventType = st.nextToken();
			String message = st.nextToken();
			
			event.setType(EventType.valueOf(eventType));
			event.setId(userToken);
			event.setMessage(message);
		}
		
		return event;
	}

}
