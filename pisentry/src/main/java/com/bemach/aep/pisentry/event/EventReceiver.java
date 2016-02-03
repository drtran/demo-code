package com.bemach.aep.pisentry.event;

import com.bemach.aep.pisentry.vos.Event;

public interface EventReceiver {
	public Event receive();
}
