package com.bemach.aep.pisentry.event;

public interface UdpSender {
	public void sendTo(String msg, String host, int port);
}	
