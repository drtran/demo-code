package com.bemach.aep.pisentry.event;

import com.bemach.aep.pisentry.vos.Event;

public interface EventSender {
	public void send(Event event);
}
