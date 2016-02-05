package com.bemach.aep.pisentry.event;

import com.bemach.aep.pisentry.vos.Event;

public interface EventProcessor {
	public void process(Event event);
}
