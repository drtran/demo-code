package com.bemach.aep.pisentry.event;

import java.io.IOException;
import java.net.SocketException;

import com.bemach.aep.pisentry.vos.Event;

public interface EventReceiver {
	public Event receive() throws SocketException, IOException;
}
