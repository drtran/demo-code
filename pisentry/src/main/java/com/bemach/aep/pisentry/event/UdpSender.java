package com.bemach.aep.pisentry.event;

import com.bemach.aep.pisentry.vos.Event;

public interface UdpSender {
	public void sendTo(Event event, String host, int port);
}	
